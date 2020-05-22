class PagerAdapter extends FragmentPagerAdapter {
        String tabTitles[] = new String[] { "One", "Two", "Three", "Four"};
        Context context;

        //This will contain your Fragment references:
        public Fragment[] fragments = new Fragment[tabTitles.length];

        public PagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }
        @Override
        public int getCount() {
            return tabTitles.length;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();   
            case 3:
                return new FragmentFour();
            }
            return null;
        }

        //This populates your Fragment reference array:
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
            fragments[position]  = createdFragment;
            return createdFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }         
 }