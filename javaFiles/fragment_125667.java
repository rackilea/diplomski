PagerAdapter mPagerAdapterExam = new PagerAdapter(getSupportFragmentManager(), this);

    mPagerAdapterExam.addFragment(new CurrentOrdersFragment(), "Current Orders");
    mPagerAdapterExam.addFragment(new PastOrdersFragment(), "Past Orders");

    mViewPager.setAdapter(mPagerAdapterExam);
    mTabLayout.setupWithViewPager(mViewPager);