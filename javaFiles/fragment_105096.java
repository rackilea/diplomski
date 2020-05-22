@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_admin);
    auth = FirebaseAuth.getInstance();
    mdrawerl = (DrawerLayout) findViewById(R.id.drawer);
    mtoggle = new ActionBarDrawerToggle(this,mdrawerl,R.string.open, R.string.close);
    mdrawerl.addDrawerListener(mtoggle);
    NavigationView nvDrawer = (NavigationView) findViewById(R.id.nv) ;
    mtoggle.syncState();
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    setupDrawerContent(nvDrawer);

    memberFragment frag = new memberFragment();
    getSupportFragmentManager().beginTransaction()
            .replace(R.id.flcontent, frag)
            .commit();


}