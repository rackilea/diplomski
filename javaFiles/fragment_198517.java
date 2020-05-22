@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.activity_activityfeed_screen, container, false);

    activityfeed_feedList_listView = (ListView)v.findViewById(android.R.id.list);
    activityfeed_feedList_listView.setAdapter(adapter);
    activityfeed_feedList_listView.setOnItemClickListener(this);

    return v;
}