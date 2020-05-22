public boolean mDrawerOpened;

    ActionBarDrawerToggle abdt = new ActionBarDrawerToggle( ... ) {

        public void onDrawerClosed(View v) {
            super.onDrawerClosed(v);
            mDrawerOpened = false;
            invalidateOptionsMenu();
            syncState();
        }

        public void onDrawerOpened(View v) {
            super.onDrawerClosed(v);
            mDrawerOpened = true;
            invalidateOptionsMenu();
            syncState();
        }