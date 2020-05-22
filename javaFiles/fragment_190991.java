searchMenuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {

        @Override
        public boolean onMenuItemActionExpand(MenuItem item) {
            return true;
        }

        @Override
        public boolean onMenuItemActionCollapse(MenuItem item) {
            refreshSearch("");
            return true;
        }
    });