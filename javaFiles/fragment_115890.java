@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    instance = this;
    setContentView(R.layout.second_activity);
    mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    mTabHost.setup(this,getSupportFragmentManager());

    // Initializing ViewPager and TabHost objects:
    mViewPager = new ViewPager(this);
    mViewPager.setId(R.id.viewpager);
    setContentView(mViewPager);


}