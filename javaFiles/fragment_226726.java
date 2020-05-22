friendList = (ListView) findViewById(R.id.mainListView);

list = new ArrayList<String>();

ArrayAdapter<String> adapter = new ArrayAdapter<String>(currentActivity,
        R.layout.friendlist_layout, R.id.textview, list);
friendList.setAdapter(adapter);

adapter.add("francesco");
adapter.add("funkyserver");

adapter.notifyDataSetChanged();