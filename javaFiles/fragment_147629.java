@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementRecyclerView= findViewById(R.id.recyclerView_element_list);
        elementRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // init mElementList  here
        mElementList = new ArrayList<>();
        mElementAdapter = new ElementAdapter(mElementList,this);
        elementRecyclerView.setAdapter(mElementAdapter);

        // Start background task
        NetworkUtils networkingTask = new NetworkUtils(this);
        networkingTask.execute(url);

    }