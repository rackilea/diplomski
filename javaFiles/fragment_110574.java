@Override
  protected void onCreate(Bundle savedInstanceState) {
   setTitle("Нүүр");
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_harnaa);


   BottomNavigationView botNavView = findViewById(R.id.bot_nav_view);
   botNavView.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

  }