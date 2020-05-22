final ColorsFragment colorsFragment = new ColorsFragment();
final LyricsFragment lyricsFragment = new LyricsFragment();
final LastFmFragment lastFmFragment = new LastFmFragment();

final FragmentManager fragmentManager = getSupportFragmentManager();
Fragment activeFragment = colorsFragment;

BottomNavigationView bottomNavigationView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (!isNotificationServiceRunning()) {
        startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
    bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {

        switch (menuItem.getItemId()) {
            case R.id.nav_colors:
                fragmentManager.beginTransaction().hide(activeFragment).show(colorsFragment).commit();
                activeFragment = colorsFragment;
                break;
            case R.id.nav_lyrics:
                fragmentManager.beginTransaction().hide(activeFragment).show(lyricsFragment).commit();
                activeFragment = lyricsFragment;
                break;
            case R.id.nav_last_fm:
                fragmentManager.beginTransaction().hide(activeFragment).show(lastFmFragment).commit();
                activeFragment = lastFmFragment;
                break;
        }

        return true;
    });

    fragmentManager.beginTransaction().add(R.id.fragment_container, lastFmFragment, "2").hide(lastFmFragment).commit();
    fragmentManager.beginTransaction().add(R.id.fragment_container, lyricsFragment, "1").hide(lyricsFragment).commit();
    fragmentManager.beginTransaction().add(R.id.fragment_container, colorsFragment, "0").commit();
}