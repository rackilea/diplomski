@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_expandable_list);

    // get the listview
    expListView = (ExpandableListView) findViewById(R.id.lvExp);
    // preparing list data
    prepareListData();

    listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);



    // setting list adapter
    expListView.setAdapter(listAdapter);
}