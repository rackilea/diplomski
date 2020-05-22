@Override
        public boolean onOptionsItemSelected(
                MenuItem item) {
            // The action bar home/up action should open or close the drawer.
            // ActionBarDrawerToggle will take care of this.

            /*
             * if (mDrawerToggle.onOptionsItemSelected((MenuItem) item)) { return
             * true; }
             */
            // Handle action buttons
            switch (item.getItemId()) {

            case android.R.id.home:
                if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                    mDrawerLayout.closeDrawer(mDrawerList);
                } else {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
                return true;
        break;

            default:
                return true;
            }
            return super.onOptionsItemSelected(item);

        }

    /* The click listner for ListView in the navigation drawer */
        private class DrawerItemClickListener implements
                ListView.OnItemClickListener {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id) {

                if (position == 1) {

                    mDrawerLayout.closeDrawer(mDrawerList);
                } else if (position == 2) {

                    mDrawerLayout.closeDrawer(mDrawerList);
                }

            }
        }

        @Override
        protected void onPostCreate(Bundle savedInstanceState) {
            super.onPostCreate(savedInstanceState);
            // Sync the toggle state after onRestoreInstanceState has occurred.
            mDrawerToggle.syncState();
        }

        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            // Pass any configuration change to the drawer toggls
            mDrawerToggle.onConfigurationChanged(newConfig);
        }