private RecyclerView recyclerView;
      public MyAdapter mAdapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //Log.i("MainActivity", "Hello World");

            // get the recycler view
            recyclerView = (RecyclerView) findViewById(R.id.noodleRecycler);


            //specify an adapter
            mAdapter = new MyAdapter(noodlesDataset);
  LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
            recyclerView.setAdapter(mAdapter);

            recyclerView.setLayoutManager(layoutManager);