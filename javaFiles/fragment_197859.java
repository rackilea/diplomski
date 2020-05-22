public class SectionsPagerAdapter extends FragmentPagerAdapter {
  ...
  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        TabTitle tabTitle = new TabTitle();
        // Where is my Arguments?
        return tabTitle;
      case 1:
        TabPosts tabPosts = new TabPosts();
        return tabPosts;
      case 2:
        TabLocation tabLocation = new TabLocation();
        // Please, give me the arguments!
        return tabLocation;
      default:
        return null;
    }
  }
  ...
}