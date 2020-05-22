@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);            
        managerDatabaseAdapter = new ManagerDatabaseAdapter(this);
        setContentView(R.layout.activity_main);
        adapter = new RVAdapter(this, managerDatabaseAdapter.getTheCursor());
        RV = (RecyclerView) findViewById(R.id.mainV);
        layoutManager = new LinearLayoutManager(this);
        RV.setLayoutManager(layoutManager);
        RV.setAdapter(adapter);
    }