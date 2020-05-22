private void setupNavDrawer(NavigationView navigationView) {
    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

             Fragment fragment = null;

             switch (item.getItemId()){
                case R.id.nav_gallery:
                   fragment = new GalleryFragment();
                   break;
                case R.id.nav_share:
                   fragment = new ShareFragment();
                   break;
                default:
                   fragment = new GalleryFragment();
                   break;

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

           //if checked - set title menu
            item.setChecked(true);
            setTitle(item.getTitle());
            mDrawerLayout.closeDrawers();

            return true;
        }
    }); 
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ............//nav
    setupNavDrawer(navigationView);
}