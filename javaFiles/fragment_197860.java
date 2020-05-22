public class SectionsPagerAdapter extends FragmentPagerAdapter {

  private Bundle bundleTitle;
  private Bundle bundleLocation;

    public SectionsPagerAdapter(FragmentManager fm, Bundle bundleTitle, Bundle bundleLocation) {
        super(fm);

      // save the bundle to local variable
      this.bundleTitle = bundleTitle;
      this.bundleLocation = bundleLocation;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TabTitle tabTitle = new TabTitle();
                // set the argument here
                tabTitle.setArguments(bundleTitle);
                return tabTitle;
            case 1:
                TabPosts tabPosts = new TabPosts();
                return tabPosts;
            case 2:
                TabLocation tabLocation = new TabLocation();
                // set the argument here
                tabTitle.setArguments(bundleLocation);
                return tabLocation;
            default:
                return null;
        }
    }

    ...
}