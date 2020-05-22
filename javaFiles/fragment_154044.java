@Override
public void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    super.onListItemClick(l, v, position, id);

    searchResults.get(position);
    Log.i("requiredvalue", ""+searchResults.get(position));
}