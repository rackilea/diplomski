protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
   // this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    setContentView(R.layout.activity_main);
    wareHousAPIWrapper = new WareHousAPIWrapper(getApplicationContext(), MainActivity.this);

    mToolbar = (Toolbar) findViewById(R.id.tool_bar);
    FloatingActionButton mFab = (FloatingActionButton) findViewById(R.id.fab);

    mFab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            wareHousAPIWrapper.getWarehouse();
        }
    });

    if (mToolbar != null) {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("sample");
    }

    wareHousAPIWrapper.getWarehouse();
    RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.staggering_grid);
    GridItemSpaces decoration = new GridItemSpaces(10);
    mRecyclerView.addItemDecoration(decoration);
}