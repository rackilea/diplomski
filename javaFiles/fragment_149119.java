// A Collection which holds your values
List<YourFriendObject> list = new ArrayList<YourFriendObject>();

// fill the Collection with your data
// you should use for-each but I dont know your object
for (int i = 0; i < friendArray.length; i++)
  list.add(friendArray[i]);

// The ArrayAdapter takes a layout, in this case a standard one
// and the collection with your data
ArrayAdapter<YourFriendObject> adapter = new ArrayAdapter(this,
    android.R.layout.simple_list_item_1, list);

 // provide the adapter to your listview
frienListView.setAdapter(adapter);