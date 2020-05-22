mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

  @Override
  public void onPageSelected(int position) {

        // do this instead, assuming your adapter reference
        // is named mAdapter:
        Fragment frag = mAdapter.fragments[position];
        if (frag != null && frag instanceof FragmentTwo) {
          ((FragmentTwo)frag).sendGetRequest();
        }
  }

  @Override
  public void onPageScrollStateChanged(int state) {  }
});