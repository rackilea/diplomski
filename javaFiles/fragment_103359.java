public boolean onCreateOptionsMenu(Menu menu) {
            if (getSupportActionBar().getSelectedNavigationIndex() == 1) {
                menu.add("Share")
                .setIcon(android.R.drawable.ic_menu_share)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            }
            if (getSupportActionBar().getSelectedNavigationIndex() == 0)) {
                menu.add("Settings")
            .setIcon(android.R.drawable.ic_menu_manage)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);      
            }

            return true;
        }