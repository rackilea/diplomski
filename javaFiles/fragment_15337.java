public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private PlaceholderFragment fragmentZero = null;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        PlaceholderFragment tabFragment = PlaceholderFragment.newInstance(position + 1);                

        if (position == 0) {
            fragmentZero = tabFragment;
        }

        return tabFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public PlaceholderFragment getFragmentZero() {
        return fragmentZero;
    }
}