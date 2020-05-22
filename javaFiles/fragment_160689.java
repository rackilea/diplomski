TabLayout mTabLayout;
ViewPager mViewPager;
TabsPagerAdapte mAdapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    // Tab layout
    mTabLayout = (TabLayout) findViewById(R.id.tabs);

    // View pager
    mViewPager  = (ViewPager) findViewById(R.id.view_pager);

    // Adapter
    mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

    // 2 Tabs
    mAdapter.addFrag(new FragmentOne(), "ONE");
    mAdapter.addFrag(new FragmentTwo(), "TWO");

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