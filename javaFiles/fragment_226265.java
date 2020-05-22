@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.searchresult_layout);

    returnList = new ArrayList<>();     //I wish to add the text from the ListView item to this list.

    ArrayList<String> list = new ArrayList<>();
    ListView lv = (ListView)findViewById(R.id.ListView_searchResultList);
    ListViewSearchResult listAdapter = new ListViewSearchResult(list, this);      //Use custom class to inflate custom layout
    lv.setAdapter(listAdapter);

    listAdapter.setOnAddListener(new ListViewSearchResult.OnAddListener() {
        @Override
        public void onAdd(int position, String text) {
            // do something ...
        }
    });
}