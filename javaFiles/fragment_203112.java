public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.

            Log.d(LOG_TAG, "postion " + position);
            if (position == 0) {
                return Fragment1.newInstance(position + 1);
            } else if (position == 1) {
                return Fragment2.newInstance(position + 1);
            } else {
                return Fragment3.newInstance(position + 1);
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return "Fragment1";
                case 1:
                    return "Fragment2";
                case 2:
                    return "Fragment3";


            }
            return null;
        }

    }