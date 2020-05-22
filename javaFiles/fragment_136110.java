List<Fragment> fragments;

public Fragment getItem(int pos) {
  return fragments.get(pos);
}

public void addFragment(Fragment f) {
  fragments.add(f);
}