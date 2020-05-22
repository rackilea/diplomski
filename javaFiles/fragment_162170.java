public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView navRecyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<NavigationDataModel> arrayList = new ArrayList<>();
    NavigationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        navRecyclerView = findViewById(R.id.navRecyclerView);
        navRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        navRecyclerView.setLayoutManager(layoutManager);

        initArray();

        adapter = new NavigationAdapter(this, arrayList);
        navRecyclerView.setAdapter(adapter);


    }

    private void initArray() {

        NavigationDataModel model = new NavigationDataModel();
        model.setColor(ContextCompat.getColor(this, R.color.colorPrimary));
        model.setIcon(R.drawable.ic_menu_gallery);
        model.setTitle("Item 1");
        arrayList.add(model);


        NavigationDataModel model2 = new NavigationDataModel();
        model2.setColor(ContextCompat.getColor(this, R.color.colorRed));
        model2.setIcon(R.drawable.ic_menu_camera);
        model2.setTitle("Item 2");
        arrayList.add(model2);

        NavigationDataModel model3 = new NavigationDataModel();
        model3.setColor(ContextCompat.getColor(this, R.color.colorGreen));
        model3.setIcon(R.drawable.ic_menu_send);
        model3.setTitle("Item 3");
        arrayList.add(model3);

        NavigationDataModel model4 = new NavigationDataModel();
        model4.setColor(ContextCompat.getColor(this, R.color.colorPink));
        model4.setIcon(R.drawable.ic_menu_share);
        model4.setTitle("Item 4");
        arrayList.add(model4);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}