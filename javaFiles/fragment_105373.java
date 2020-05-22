public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        TabLayout.Tab tabCall = tabLayout.getTabAt(0);
        tabCall.setIcon(R.drawable.selector_call);

        TabLayout.Tab tabHeart = tabLayout.getTabAt(1);
        tabHeart.setIcon(R.drawable.selector_heart);

        TabLayout.Tab tabContacts = tabLayout.getTabAt(2);
        tabContacts.setIcon(R.drawable.selector_contacts);
    }

    class TabPagerAdapter extends FragmentPagerAdapter {

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new CallFragment();
                case 1:
                    return new HeartFragment();
                case 2:
                    return new ContactsFragment();
            }

            return null;
        }
    }
}