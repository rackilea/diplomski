protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_app_intro2);
    viewPager = (ViewPager) findViewById(R.id.viewPager);

    PageFragment.SwipeAdapter swipeAdapter = new PageFragment.SwipeAdapter(getSupportFragmentManager());
    viewPager.setAdapter(swipeAdapter);
    circleIndicator = (CirclePageIndicator) findViewById(R.id.circleIndicator);
    circleIndicator.setupWithViewPager(viewPager);


 }