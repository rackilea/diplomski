@Override
protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setTitle("");
 setContentView(R.layout.activity_user_area);

 Intent intentMain = getIntent();
 String dpdisplayName = intentMain.getStringExtra("displayName");

 Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
 setSupportActionBar(toolbar);

 DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
 ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
 drawer.setDrawerListener(toggle);
 toggle.syncState();

 NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
 View headerView = navigationView.getHeaderView(0);
 TextView navdisplayName = (TextView) headerView.findViewById(R.id.displayName);
 navdisplayName.setText(dpdisplayName);
}