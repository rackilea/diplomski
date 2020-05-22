private void setupViewPager(ViewPager viewPager){
    SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
    Fragment1 f1 = new Fragment1();
    Fragment2 f2 = new Fragment2();
    f1.setListener(f2);
    adapter.addFragment(f1, "Fragment 1");
    adapter.addFragment(f2, "Fragment 2");
    viewPager.setAdapter(adapter);
}