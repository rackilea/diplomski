public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private FrameLayout baseLayout;
    public ActionBarDrawerToggle drawerToggle;
    public Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_layout);
        toolbar = (Toolbar) findViewById( R.id.toolbar);
        setSupportActionBar(toolbar);
        baseLayout = (FrameLayout) findViewById(R.id.base_view);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(drawerToggle);
    }

    @Override
    public void setContentView(View view) {
        if (baseLayout != null) {
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            baseLayout.addView(view, params);
        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (baseLayout != null) {
            baseLayout.addView(view, params);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //TODO
        return false;
    }
}