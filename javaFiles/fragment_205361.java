@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // ...
    setHasOptionsMenu(true);
}

@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.menu_main, menu);
    super.onCreateOptionsMenu(menu, inflater);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case R.id.menu_item_1:
        // handling menu item click
        break;
    }
    return super.onOptionsItemSelected(item);
}