@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise and set toolbar as actionbar
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        // initialize nav bars
        initNavBars();

        // initialize drawer layout
        NavigationView navView = (NavigationView) findViewById(R.id.navigation_view);

        // initialize nav drawer
        navDrawer = (DrawerLayout) findViewById(R.id.drawer);
        initNavDrawer(navDrawer);

        // initialize layout manager for recycler view
        RecyclerView.LayoutManager mainLayoutManager = new LinearLayoutManager(this);

        // initialize data for all classes before setting adapter
        initClassData(); // <---- PARSE QUERY IS STILL IN THIS METHOD

        // set the adapter for recycler view
        RecyclerView.Adapter mainAdapter = new MainRecyclerAdapter(classrooms);

        // initialize recycler view elements
        RecyclerView mainRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        // add layout manager to recycler view
        mainRecyclerView.setLayoutManager(mainLayoutManager);

        // add adapter to recycler view
        mainRecyclerView.setAdapter(mainAdapter);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                // Do something after 5s = 5000ms
                Toast.makeText(getApplicationContext(), userClasses[PERIOD1], Toast.LENGTH_SHORT).show();
            }
        }, 5000);
    }