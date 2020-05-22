public class SectionsPagerAdapter extends FragmentPagerAdapter {
  Context activity;
  SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

  public SectionsPagerAdapter(FragmentManager fm, Context activity) {
    super(fm);
    this.activity = activity;
  }

  @Override
  public Fragment getItem(int position) {
    // getItem is called to instantiate the fragment for the given page.
    return PlaceholderFragment.newInstance(position);
  }

  @Override
  public int getCount() {
    return 3;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    switch (position) {
        case 0:
            return activity.getString(R.string.chart);
        case 1:
            return activity.getString(R.string.weight_diary);
        case 2:
            return activity.getString(R.string.how_to);
      }
      return null;
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    Fragment fragment = (Fragment) super.instantiateItem(container, position);
    registeredFragments.put(position, fragment);
    return fragment;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    registeredFragments.remove(position);
    super.destroyItem(container, position, object);
  }

  public Fragment getRegisteredFragment(int position) {
    return registeredFragments.get(position);
    //maybe use adapater.getRegisteredFragment(viewPager.getCurrentItem());
  }
}