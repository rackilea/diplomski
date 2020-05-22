@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);

    MenuItem findItem = menu.findItem(R.id.menu_action_search);
    searchView = (SearchView) findItem.getActionView();

    // Add this code
    SearchView.SearchAutoComplete searchTextView = searchView.findViewById(R.id.search_src_text);
    try {
        Field field = TextView.class.getDeclaredField("mCursorDrawableRes");
        field.setAccessible(true);
        field.set(searchTextView, R.drawable.my_cursor);
    } catch (Exception e) {
        // Ignore exception
    }

    // Your logic code here

    return super.onCreateOptionsMenu(menu);
}