@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // TODO Auto-generated method stub


    int itemId = item.getItemId();

    if (item.getItemId() == android.R.id.home) {

        if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
             mDrawerLayout.closeDrawer(Gravity.END);
            mDrawerLayout.openDrawer(mDrawerList);
        }
    }

    return super.onOptionsItemSelected(item);
}