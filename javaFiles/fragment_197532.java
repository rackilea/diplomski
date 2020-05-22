private void addPages(ViewPager pager) {
    MyFragPagerAdapter adapter = new MyFragPagerAdapter(getSupportFragmentManager());
    adapter.addPage(new ContainerFragment());

    //SET ADAPTER TO PAGER
    pager.setAdapter(adapter);

}