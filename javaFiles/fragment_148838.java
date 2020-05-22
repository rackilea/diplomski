protected void setUpHeader(int headerRequestingActivity) {
    setContentView(headerRequestingActivity);
    headerPresenter = new HeaderPresenterImpl(this);
    drawerHeaderView = findViewById(R.id.navigationheader);
    toolbar = (Toolbar) findViewById(R.id.tbHeader);
    setSupportActionBar(toolbar);

    final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
    final NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
    navigationView.setNavigationItemSelectedListener(this);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
        @Override
        public void onDrawerStateChanged(int newState) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                //do something on opening the navigation
            } else {
                //optional actions when navigation menu closes
            }
        }
    };
    drawer.setDrawerListener(toggle);
    toggle.syncState();
}