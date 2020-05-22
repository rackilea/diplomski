// Lets assume you have some list of msgs and a adapter
// You could store those as class variables
List<String> msgs = new ArrayList<String>();
SimpleAdapter adapter = new SimpleAdapter(context, msgs, R.layout.lv_layout, from, to);

// Point ListView to use previously created adapter
ListView lvMsgs = ( ListView ) findViewById(R.id.lvMsgs);
lvMsgs.setAdapter(adapter);

// later in code do some updates to the list of objects
// and notify the adapter that it should refresh its content
msgs.add("SomeString");
adapter.notifyDataSetChanged();