package com.basil.victor;
    import android.graphics.drawable.Drawable;
    import android.os.Bundle;
    import android.support.v4.app.Fragment;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ListView;

    import java.io.IOException;
    import java.io.InputStream;

    public class Events extends Fragment {

    private ListView listEvent;

    String eventname[]={
        "Name",
        "of",
        "the",
        "events",
        "are",
        "present",
        "here"
    };

    String eventlogoname[]={
        "Logo",
        "name",
        "of",
        "events",
        "are",
        "present",
        "here"
    };

    Drawable[] arr=new Drawable[7];

    String eventsubtitle []={
        "Subtitles",
        "of",
        "the",
        "events",
        "are",
        "present",
        "here"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_events, null);



    for(int i=0;i<7;i++) {
        try {
            InputStream stream = getContext().getAssets().open(eventlogoname[i] + ".jpg");
            Drawable el = Drawable.createFromStream(stream, null);
            arr[i] = el;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    EventList adapter = new
            EventList(getActivity(), eventname, arr, eventsubtitle);
    //ListView lv = (ListView)rootView.
    listEvent=(ListView)view.findViewById(R.id.listEvent);
    listEvent.setAdapter(adapter);


         listEvent.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {

                 FragmentTransaction trans = getFragmentManager()
                        .beginTransaction();
                /*
                 * IMPORTANT: We use the "root frame" defined in
                 * "root_fragment.xml" as the reference to replace fragment
                 */
                trans.replace(R.id.root_frame, new SecondFragment());

                /*
                 * IMPORTANT: The following lines allow us to add the fragment
                 * to the stack and return to it later, by pressing back
                 */
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);

                trans.commit();
                    }
                });

        return view;
        }
        }