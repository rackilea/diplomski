public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

    public AppSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {

            default:
                return new ExampleFragment();
        }
    }

    @Override
    public int getCount() {
        return 1;
    }
}