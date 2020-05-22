public MenuItem mi;

public boolean onPrepareOptionsMenu(Menu menu) {
    if (mi == null) { mi = menu.findItem(R.id.ofertasRefresh); }
    if (mDrawerOpened) { mi.setVisible(false); }
    if (!mDrawerOpened) { mi.setVisible(true); }
    return super.onPrepareOptionsMenu(menu);
}