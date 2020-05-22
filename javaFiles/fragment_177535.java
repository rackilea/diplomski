@Override
public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    MenuItem menuItem = menu.findItem(R.id.search);

    //...

    MenuItemCompat.setOnActionExpandListener(menuItem, new MenuItemCompat.OnActionExpandListener() {
        @Override
        public boolean onMenuItemActionExpand(MenuItem item) {
            findViewById(R.id.button).setEnabled(false);
            return true;
        }

        @Override
        public boolean onMenuItemActionCollapse(MenuItem item) {
            findViewById(R.id.button).setEnabled(true);
            return true;
        }
    });

    return true;
}