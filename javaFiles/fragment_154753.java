@Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        sharedPreference.removeFavorite(cartActivity.this, favorites.get(position));
        favorites.remove(position);
        refreshDisplay();
        Toast.makeText(cartActivity.this, "Success Remove",Toast.LENGTH_SHORT).show();

        return true;
    }