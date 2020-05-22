NavigationView navigationView = findViewById(R.id.nav_view);
//R.id.nav_view the id of the navigation drawer

View drawerHead = navigationView.getHeaderView(0);
//0 index of the header

TextView userName = drawerHead.findViewById(R.id.username);