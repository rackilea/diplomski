private void customizeSearchView() {
        int searchTextId = getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText searchBox = ((EditText) searchView.findViewById(searchTextId));
        searchBox.setBackgroundColor(Color.WHITE);
        searchBox.getLayoutParams().height = LinearLayout.LayoutParams.MATCH_PARENT;
        int search_plateId = getResources().getIdentifier("android:id/search_plate", null, null);
        View mSearchPlate = ((View) searchView.findViewById(search_plateId));
        mSearchPlate.setBackgroundColor(Color.BLUE);

        int searchCloseImageId = getResources().getIdentifier("android:id/search_close_btn", null, null);
        ImageView searchClose = ((ImageView) searchView.findViewById(searchCloseImageId));// change color
        searchClose.setBackgroundColor(Color.WHITE);
    }