private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        frag1=new OneFragment();
        frag2=new TwoFragment();
        frag3=new ThreeFragment();

        adapter.addFragment(frag1, "ƏSAS");
        adapter.addFragment(frag2, "VIRTUAL TUR");
        adapter.addFragment(frag3, "ÜNVANIMIZ");
        viewPager.setAdapter(adapter);
    }