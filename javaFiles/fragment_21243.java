NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
// If the view has not been set in the xml then here should be a null check because there is going to be no header view 
// and there will be no need to remove that
View hView =  navigationView.getHeaderView(0);
navigationView.removeHeaderView(hView);
navigationView.inflateHeaderView(R.layout.nav_my_other_header);