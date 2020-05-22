tabLayout = (TabLayout) findViewById(R.id.tabLayout);
viewPager = (ViewPager) findViewById(R.id.pager);

BasePagerAdapter adapter = new BasePagerAdapter(getSupportFragmentManager());
adapter.addFragment(new Tab1(), "All");
adapter.addFragment(new Tab2(), "Western");
adapter.addFragment(new Tab3(), "-");

viewPager.setAdapter(adapter);
tabLayout.setOnTabSelectedListener(this);
tabLayout.setupWithViewPager(viewPager);