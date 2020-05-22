ListView listView = (ListView) findViewById(R.Id.ListView);
listView.setOnItemClickListener(new OnItemClickListener() {
      public void onItemClick(AdapterView<?> parent, View view,
          int position, long id) {
          // position is the index of selected item
          // Launching new Activity on selecting single List Item
          Intent i = new Intent(MainActivity.this, SecondActivity.class);
          // sending data to new activity
          i.putExtra("item", list.get(position));
          startActivity(i);
      }
  });