TabLayout mTabLayout;
ViewPager mViewPager;
TabsPagerAdapte mAdapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_third);

    // Tab layout
    mTabLayout = (TabLayout) findViewById(R.id.tabs);

    // View pager
    mViewPager  = (ViewPager) findViewById(R.id.view_pager);

    // Adapter
    mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

    // 3 Tabs
    mAdapter.addFrag(new FragmentOne(), "ONE");
    mAdapter.addFrag(new FragmentTwo(), "TWO");
    mAdapter.addFrag(new FragmentThree(), "THREE");

    mViewPager.setAdapter(mAdapter);

    mTabLayout.setupWithViewPager(mViewPager);
    mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {

            mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });
}