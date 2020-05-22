@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
        if(mDrawerLayout.isDrawerOpen(mFrameHoldingList)) {
            mDrawerLayout.closeDrawer(mFrameHoldingList);
        }else {
            mDrawerLayout.openDrawer(mFrameHoldingList);
        }
        break;

    default:
        break;
    }
    return super.onOptionsItemSelected(item);
}