@Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.search);

         nsv = (NestedScrollView) findViewById(R.id.activity_main);
         firstRecyclerView = (RecyclerView)findViewById(R.id.recycler);
         secondRecyclerView = (RecyclerView)findViewById(R.id.recycler_2);
         thirdRecyclerView = (RecyclerView) findViewById(R.id.recycler_3);
         fourthRecyclerView = (RecyclerView) findViewById(R.id.recycler_s);
         fifhtRecyclerView = (RecyclerView) findViewById(R.id.recycler_);

         //create and set layout manager for each RecyclerView

        firstRecyclerView.setNestedScrollingEnabled(false);
         RecyclerView.LayoutManager firstLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
         //RecyclerView.LayoutManager secondLayoutManager = new LinearLayoutManager(this);
         //RecyclerView.LayoutManager thirdLayoutManager = new LinearLayoutManager(this);
         //RecyclerView.LayoutManager fourthLayoutManager = new LinearLayoutManager(this);
         //RecyclerView.LayoutManager fiveLayoutManager = new LinearLayoutManager(this);

         firstRecyclerView.setLayoutManager(firstLayoutManager);
         //secondRecyclerView.setLayoutManager(secondLayoutManager);
         //thirdRecyclerView.setLayoutManager(thirdLayoutManager);
         //fourthRecyclerView.setLayoutManager(fourthLayoutManager);
         //fifhtRecyclerView.setLayoutManager(fiveLayoutManager);




         firstRecyclerView.setHasFixedSize(true);
         //secondRecyclerView.setHasFixedSize(true);
         //thirdRecyclerView.setHasFixedSize(true);
         //fourthRecyclerView.setHasFixedSize(true);
         //fifhtRecyclerView.setHasFixedSize(true);



         GetDataAdapter1 =  new ArrayList<>();
         //GetDataAdapter2 =  new ArrayList<>();
         //GetDataAdapter3 =  new ArrayList<>();
         //GetDataAdapter4 =  new ArrayList<>();
         //GetDataAdapter5 =  new ArrayList<>();


         JSON_DATA_WEB_CALL_VIEWS();
         //JSON_DATA_WEB_CALL_DONES();
         //JSON_DATA_WEB_CALL_LIKES();
         //JSON_DATA_WEB_CALL_IDS();
         //JSON_DATA_WEB_CALL_RANDOM();


     }