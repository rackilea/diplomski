for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
    Map<String, String> map = (Map<String, String>) childSnapshot.getValue();
    Buyers buyerList = new Buyers(map);
    filteredUsernames.add(buyerList.getData());
}

 searchModule.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        filteredArrayAdapter.getFilter().filter(newText);
        filteredArrayAdapter.notifyDataSetChanged();
        return true;
    }
});