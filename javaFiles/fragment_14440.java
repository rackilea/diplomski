public class PagerDialog extends DialogFragment {

    public static PagerDialog newInstance() {
        return new PagerDialog();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_fragment, container, false);

        ViewPager mViewPager = (ViewPager) v.findViewById(R.id.view_pager);

        /* Use childFragmentManager here provided from the PagerDialog */
        MyAdapter mAdapter = new MyAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);

        return v;
    }

    private class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int index) {
            return new DummyFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }

    }
}