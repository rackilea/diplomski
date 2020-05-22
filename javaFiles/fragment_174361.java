public class MainActivityFragment extends FragmentActivity {
    private ViewPager mPager = null;
    private PagerAdapter mPageAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View reVal = inflater.inflate(R.layout.activity_main, container, false);
        mPager = (ViewPager) reVal.findViewById(R.id.pagerMainContent);
        mPageAdapter = new ScreenSlidePagerAdapter(getChildFragmentManager());
        mPager.setAdapter(mPageAdapter);
        return reVal;
    }

    private MainGridViewFragment mainGridFragment;
    private AlphabetGridViewFragment alphabetGridFragment;

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 1:
                    mainGridFragment = new MainGridViewFragment();
                    return (Fragment)mainGridFragment;
                case 0:
                    alphabetGridFragment = new AlphabetGridViewFragment();
                    return (Fragment)alphabetGridFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}