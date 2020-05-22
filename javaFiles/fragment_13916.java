private List<CustomModel> modelList = new ArrayList<>();
private RecyclerView recyclerView;
private RecyclerAdapter mAdapter;


recyclerView = (RecyclerView) findViewById(R.id.recycler_view); 
mAdapter = new RecyclerAdapter(modelList);

RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
recyclerView.setLayoutManager(mLayoutManager);
recyclerView.setItemAnimator(new DefaultItemAnimator());

recyclerView.setAdapter(mAdapter);