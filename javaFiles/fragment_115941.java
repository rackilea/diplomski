navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        boolean handled = NavigationUI.onNavDestinationSelected(item, navController);

        if (!handled) {
            switch (item.getItemId()) {
                case R.id.nav_exit: {
                    Toast.makeText(Main2Activity.this, "gbfg", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.nav_get_update_app: {
                    break;
                }
                case R.id.nav_about_us: {
                    break;
                }
            }
        }

        drawer.closeDrawer(GravityCompat.START);
        return handled;
    }
});