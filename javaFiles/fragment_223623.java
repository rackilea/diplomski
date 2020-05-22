public class MainActivity extends AppCompatActivity {

private Fragment homeFragment = new HomeFragment();
private Fragment trendingFragment = new TrendingFragment();
private Fragment latestFragment = new LatestFragment();
private Fragment inboxFragment = new InboxFragment();
private Fragment libraryFragment = new LibraryFragment();
private BottomNavigationView navigation;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    navigation = findViewById(R.id.bottom_navigation);
}

@Override
public void onBackPressed() {
    if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
        finish();
    } else {
        super.onBackPressed();

        if (homeFragment.isResumed())
            navigation.setSelectedItemId(R.id.bottom_navigation_home);
        else if (trendingFragment.isResumed())
            navigation.setSelectedItemId(R.id.bottom_navigation_trending);
        else if (latestFragment.isResumed())
            navigation.setSelectedItemId(R.id.bottom_navigation_latest);
        else if (inboxFragment.isResumed())
            navigation.setSelectedItemId(R.id.bottom_navigation_inbox);
        else if (libraryFragment.isResumed())
            navigation.setSelectedItemId(R.id.bottom_navigation_library);
    }
}