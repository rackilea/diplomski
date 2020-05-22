@Override
    protected void onCreate(Bundle savedInstanceState) {

ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
       SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
viewPager.setAdapter(mSectionsPagerAdapter);

// setting the views to be accessed through tabs
TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int currentTab = tab.getPosition();
                viewPager.setCurrentItem(currentTab);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


 }