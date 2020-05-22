@Override
public boolean onQueryTextChange(String newText) {
    Log.e("Search",newText);

    search(newText);

    return true; //true
}