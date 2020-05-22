hideNavigationItem();

private void hideNavigationItem() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_draw);  
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_inicio).setVisible(false);
    }