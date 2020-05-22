public static class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return BasicButtonsFragment.newInstace();
        return ScientificButtonsFragment.newInstance();
    }
}