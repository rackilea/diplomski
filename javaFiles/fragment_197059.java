public class ViewPagerTabListViewActivity extends BaseActivity implements ObservableScrollViewCallbacks, NavigationDrawerCallbacks {

private View mHeaderView;
private View mToolbarView;
private int mBaseTranslationY;
private ViewPager mPager;
private NavigationAdapter mPagerAdapter;

private NavigationDrawerFragment mNavigationDrawerFragment;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_viewpagertab);

    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

    mHeaderView = findViewById(R.id.header);
    ViewCompat.setElevation(mHeaderView, getResources().getDimension(R.dimen.toolbar_elevation));
    mToolbarView = findViewById(R.id.toolbar);
    mPagerAdapter = new NavigationAdapter(getSupportFragmentManager());
    mPager = (ViewPager) findViewById(R.id.pager);
    mPager.setAdapter(mPagerAdapter);

    SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
    slidingTabLayout.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);
    slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.accent));
    slidingTabLayout.setDistributeEvenly(true);
    slidingTabLayout.setViewPager(mPager);

    // When the page is selected, other fragments' scrollY should be adjusted
    // according to the toolbar status(shown/hidden)
    slidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i2) {
        }

        @Override
        public void onPageSelected(int i) {
            propagateToolbarState(toolbarIsShown());
        }

        @Override
        public void onPageScrollStateChanged(int i) {
        }
    });

    propagateToolbarState(toolbarIsShown());

    //Added this --------------------------------------------

    ActionBar ab = getSupportActionBar();
    ab.setDisplayShowHomeEnabled(false);
    ab.setDisplayHomeAsUpEnabled(true);
    ab.setHomeButtonEnabled(true);
    mNavigationDrawerFragment = (NavigationDrawerFragment)
            getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);

    // Set up the drawer.
    mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), (Toolbar) mToolbarView);
}

//Added this -----------------------------------------

@Override
public void onNavigationDrawerItemSelected(int position) {
    // update the main content by replacing fragments
    Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
}