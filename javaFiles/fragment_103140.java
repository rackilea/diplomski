You have got both data as well as list, now you need to combine them.
first you have to convert your json result into list, where values are your json values.
    final ArrayList<String> listdata = new ArrayList<String>();
    for (int i = 0; i < values.length; ++i) {
      listdata .add(values[i]);
    }

then you have to assign adapter to your list. You can use following code. 
  final StableArrayAdapter adapter = new StableArrayAdapter(this,
        android.R.layout.yourlistlayout, listdata );
    list.setAdapter(adapter);