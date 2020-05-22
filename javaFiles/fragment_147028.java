@Override
protected void onResume() {
    super.onResume();

    ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
    ViewPagerAdapter adapter = (ViewPagerAdapter) pager.getAdapter();
    Fragment fragment = adapter.getItem(0);
    if (fragment instanceof MainPageProfileFragment) {
        // if we are here, then fragment is not null and has correct type
        ((MainPageProfileFragment)fragment).setLabelText("my text");
    }
}