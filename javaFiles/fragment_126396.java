item = menu.findItem(R.id.friend_fragment_search_icon);
        searchView = (SearchView) MenuItemCompat.getActionView(item);

        // When using the support library, the setOnActionExpandListener() method is
// static and accepts the MenuItem object as an argument
        MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                //the searchview has been closed
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                mBtnFindFriends.hide();
                return true;  // Return true to expand action view
            }
        });