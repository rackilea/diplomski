@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_recycler);

    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);        
    recyclerView.setHasFixedSize(true);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    dataList = new ArrayList<>();

    RequestJsonArray();

    adapter = new RecyclerViewListview(this, dataList);        
    recyclerView.setAdapter(adapter);
}