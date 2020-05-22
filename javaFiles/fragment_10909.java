public class TabPagerAdapter extends FragmentStatePagerAdapter {
 private static final int NUMBER_OF_TABS = 3;
 private Fragment[] tabList = new Fragment[NUMBER_OF_TABS];

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }
       @Override
        public Fragment getItem(int i) {
            if (tabList[i] != null) {
              // Return a tab we created earlier..
              return tabList[i];
            } else {
              switch (i) {
                  case 0:
                      tabList[0] = Information.newInstance("name");
                      return  tabList[0];
                  case 1:
                      tabList[1] = WorkForce.newInstance("SubCon");
                      return tabList[1];
                  case 2:
                      tabList[2] = WorkDetailsTable.newInstance();
                      return tabList[2];
              }
            }
            return null ;
        }
        @Override
        public int getCount() {
            return NUMBER_OF_TABS;
        }