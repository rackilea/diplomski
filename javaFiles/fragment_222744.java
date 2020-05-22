@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent = null;
        if (item.getItemId() == R.id.navigation_item_1) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(MapsActivity.this, LocationList.class);
            intent.putExtra("longitude_key", longitude);
            intent.putExtra("latitude_key", latitude);
            startActivity(intent);
            return true;
        }