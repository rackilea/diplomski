SectionsPagerAdapter mSectionsPagerAdapter = new 
    SectionsPagerAdapter(getSupportFragmentManager());

    // Set up the ViewPager with the sections adapter.
    mViewPager =  findViewById(R.id.container);
    mViewPager.setAdapter(mSectionsPagerAdapter);

    TabLayout tabLayout = findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(mViewPager)
   mSectionsPagerAdapter.addFrag(new Paid(),"Paid");
   mSectionsPagerAdapter.addFrag(new Unpaid(),"Unpaid");
   mSectionsPagerAdapter.addFrag(new ItemPosted(),"ItemPosted");