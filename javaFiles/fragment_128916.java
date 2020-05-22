@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        ((RestaurantActivityViewPager)mActivity).menuFragment=this;
    }
    public static MenuFragment newInstance(int sectionNumber) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }