@Override
protected void onResume() {
    super.onResume();
    Menu bottomMenu = bottomNavigationView.getMenu();
    for (int i=0; i<bottomMenu.size(); i++)
    {
        MenuItem bottomMenuItem = bottomMenu.getItem(0);
        bottomMenuItem.setChecked(true);
    }
}