public void populateListView(){

   ArrayAdapter<String> adapter= new ArrayAdapter<>(this, R.layout.dat_item, busList);

   //config the list view
   ListView list = (ListView) findViewById(R.id.listView5);
   list.setAdapter(adapter);