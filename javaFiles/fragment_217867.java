public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

private SessionManager session;
private SQLiteHandler db;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // SqLite database handler
    db = new SQLiteHandler(getApplicationContext());
    // session manager
    session = new SessionManager(getApplicationContext());

    if (!session.isLoggedIn()) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    } else {

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_one)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_two)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_three)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
if (tab.getPosition() == 1) {

// call your sent email request and stored that in db after that in your fragment fetch the content from db and display it on ui
}
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });