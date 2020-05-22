@Override
public void onViewCreated(View view, Bundle savedInstanceState){
    mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
    mViewPager = (ViewPager) view.findViewById(R.id.pager);
    mViewPager.setAdapter(mSectionsPagerAdapter);
}