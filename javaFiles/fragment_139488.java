NavigationView navigationView = (NavigationView) findViewById(R.id.nvView);
View navHeaderview = navigationView.getHeaderView(0);

LinearLayout navHeaderUser = (LinearLayout) navHeaderview.findViewById(R.id.nav_header_user);
    navHeaderUser.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        // Intent myIntent = new Intent(MainActivity.this, UserProfile.class);
        // MainActivity.this.startActivity(myIntent);
        // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // drawer.closeDrawer(GravityCompat.START);
        }
    });