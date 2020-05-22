@Override
public boolean onNavigationItemSelected(MenuItem item) {
    int id = item.getItemId();
    switch (id) {
        case R.id.nav_changelanguage:
            //change language logic
            break;
        case R.id.nav_logout:
            //logout user
            break;
    }
    return true;
}