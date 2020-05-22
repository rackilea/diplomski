@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);

    //search
    SearchView searchView = (SearchView)menu.findItem(R.id.app_bar_search);
    ...
}