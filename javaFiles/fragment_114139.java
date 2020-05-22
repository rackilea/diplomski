ListView listView = (ListView) findViewById(...);
listView.setAdapter(new SimpleCursorAdapter(
   this,  // The context
   R.layout.layoutToShow,  // The layout of the row to show
   dbOpen.getUnits(),  // Here the cursor where the data is, i used .getUnits()
                       // but it can be anything
   new String[] { tables to show },  // here the tables to show
   new int[] { where to put data? },  // here where to show? the IDs
                                     // of the layout elements where put data.
   0
);