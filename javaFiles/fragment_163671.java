private void UpdateDataSource() {
    SharedPreferences sharedPreferences = getSharedPreferences(DataKey.DATA_SOURCE, MODE_PRIVATE);
    Gson gson = new Gson();
    String json = sharedPreferences.getString(DataKey.SHARED_PREF_CARD_LIST, null);
    Type type = new TypeToken<ArrayList<TravelCard>>() {
    }.getType();
    //Save the new list retrieved from the SharedPref into a temporary ArrayList
    ArrayList<TravelCard> temp = gson.fromJson(json, type);
    //I copy the new list into my main list
    travelCards = temp;
    //I set the new list in the RecyclerView Adapter
    mAdapter.setTravelCards(temp);
    //Notify the adapter that  the data set has been changed
    mAdapter.notifyDataSetChanged();
}