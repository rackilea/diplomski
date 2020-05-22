@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);



    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    };




    final Toolbar toolbar = (Toolbar)findViewById(R.id.MyToolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapse_toolbar);
    collapsingToolbarLayout.setTitle("Service/DPNG");


    ArrayList<Celebrity> itemList = new ArrayList<>();

    fillDummyData(itemList);

    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

    itemAdapter = new ItemAdapter(itemList, btnListener);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(itemAdapter);
}