@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_passages);

    ListView passagesListView = (ListView) findViewById(R.id.passagesListView);
    assert passagesListView != null;

    buildPassageList();

    PassagesViewAdapter adapter = new PassagesViewAdapter(this, R.layout.passages_row_layout, passages);
    passagesListView.setAdapter(adapter);

    // ** This call results in a runtime error for null pointer reference.
    passagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position,long arg3) {
            Toast.makeText(getContext(), "Foo", Toast.LENGTH_SHORT).show();
        }
    });
}