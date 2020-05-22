public class MainActivity extends AppCompatActivity {

TabLayout tabLayout;
ViewPager viewPager;
Toolbar toolbar;
int no_of_categories=-1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    toolbar=(Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    tabLayout=(TabLayout)findViewById(R.id.tabs);
    viewPager=(ViewPager)findViewById(R.id.viewpager);

    no_of_categories=YOUR_NO_CATEGORIES;

    for (int i = 0; i < no_of_weeks; i++) {
        tabLayout.addTab(tabLayout.newTab().setText("TAB " + String.valueOf(i + 1)));
    }

    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
    viewPager.setAdapter(adapter);

    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {

            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });


   }
}