@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
            if (!isDrawerOpen) {
                mDrawerLayout.openDrawer(GravityCompat.START);
                isDrawerOpen = true;
            } else {
                mDrawerLayout.closeDrawers();
                isDrawerOpen = false;
            }
            return true;
    }
    return super.onOptionsItemSelected(item);
}

private void setupDrawerContent(NavigationView navigationView) {
    navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    menuItem.setChecked(true);
                    mDrawerLayout.closeDrawers();        //THIS CLOSES THE DRAWER; AFTER A ITEM IS SELECTED
                    isDrawerOpen = false;
                    return true;
                }
            });
}