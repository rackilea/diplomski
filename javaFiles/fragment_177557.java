@Override
protected void onPostExecute(List<Status> result) {

    myString = result.get(0).getUser().getScreenName();

    events = new ArrayList<String>();
    events.add("Item");
    events.add(myString);

    adapter = new ArrayAdapter<String> (SearchTwitter.this, android.R.layout.simple_list_item_1, events);

    setListAdapter(adapter);
}