public class ActivityBeamRec extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        // This list holds the fragments for the pages displayed by view pager.
        private List < Fragment > fragments = new ArrayList < Fragment > ();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            // Add the first fragment:
            fragments.add(PlaceholderFragment.newInstance(1));
        }

        private void addFragment(Fragment fragment) {
            fragments.add(fragment);

            // Notify view pager that the contents of the adapter has changed and that it needs to update
            // its pages:
            notifyDataSetChanged();

            // Since content of view pager has changed, re-wire tab layout:
            tabLayout.setupWithViewPager(mViewPager);

            // Set the current page in the view pager to the last added fragment:
            mViewPager.setCurrentItem(fragments.size() - 1);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Set the tab title as the number of the current section:
            return "SECTION " + (position + 1);
        }
    }

    /**
     * Adds a new fragment (page) to the view pager.
     * This method can either be public or package-private (without any modifier) depending on the package
     * of 'PlaceholderFragment'. Since you're new to Java please refer the link to access modifiers below.
     *
     * @param fragment the fragment to be added to the view pager
     **/
    public void addFragment(Fragment fragment) {
        mSectionsPagerAdapter.addFragment(fragment);
    }

    /**
     * Returns the number of the next section (page) to be added.
     *
     * @return the next section number
     */
    public int getNextSectionNumber() {
        return mSectionsPagerAdapter.getCount() + 1;
    }

}