package app.com.socialserve;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class DinnerDetail extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    ListView eventsList;
    private ParseQueryAdapter mainAdapter;
    private DinnerPartyAdapter eventsAdapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public DinnerDetail() {
        // Required empty public constructor
    }

    //Create fragment and pass info into bundle for Efficiency
    public static DinnerDetail newInstance(int sectionNumber, String name, String description, int seatsAvail, String host, String time, String location) {
        DinnerDetail fragment = new DinnerDetail();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        //set up the adapter and apply to the ListView
        mainAdapter = new DinnerPartyAdapter(view.getContext(), "host", ParseUser.getCurrentUser().getEmail(), 1);
        eventsList = (ListView) view.findViewById(R.id.eventsListView);
        eventsList.setAdapter(mainAdapter);
        return view;
    }


}