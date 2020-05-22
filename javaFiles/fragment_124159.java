@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_database_layout);

        mListView = findViewById(R.id.listview);
        CustomListAdapter adapter = new CustomListAdapter(this);
        mListView.setAdapter(adapter);

        //[...]
    }