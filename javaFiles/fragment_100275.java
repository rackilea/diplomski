@Override
public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_gallery) {
        //open gallery

        Intent galleryIntent = new Intent(YourCurrentActivity.this, PhotoActivity.class);
        //if you need to pass data: 
        Bundle mBundle = new Bundle();
        mBundle.putString("myKey", "opengalleryclicked");
        galleryIntent.putExtras(mBundle); 
        startActivity(galleryIntent);
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
}