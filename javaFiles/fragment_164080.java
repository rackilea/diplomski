public class MainActivity extends AppCompatActivity {

private final String TAG = MainActivity.class.getSimpleName();
private ActionBarDrawerToggle toggle = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
    setSupportActionBar(myToolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    final ActionBar actionBar = getSupportActionBar();

    if (actionBar != null) {

        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.open, R.string.close) {

            public void onDrawerClosed(View view) {
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                supportInvalidateOptionsMenu();
            }
        };
        toggle.setDrawerIndicatorEnabled(true);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

}

@Override
protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    if(toggle != null) {
        toggle.syncState();
    }
}

@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    if (toggle != null) {
        toggle.onConfigurationChanged(newConfig);
    }
}

}