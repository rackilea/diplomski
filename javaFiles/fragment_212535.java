private RecyclerView mRecyclerView;
private RecycleViewAdapter mAdapter;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_city);

    mRecyclerView = (RecyclerView)findViewById(R.id.list);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    mAdapter = new RecycleViewAdapter(cities, R.layout.row_city, this);
    mRecyclerView.setAdapter(mAdapter);

    mAdapter.setOnClick(MainActivity.this); // Bind the listener
}

@Override
public void onItemClick(int position) {
    // The onClick implementation of the RecyclerView item click
//ur intent code here