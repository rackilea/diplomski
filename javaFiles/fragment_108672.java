TextView content;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.listview_main);

    content = (TextView) findViewById(R.id.output);

    String[] CoffeeShop = {"Creation","Starbucks","Caribou","Mo'Joe" };

    // Define a new Adapter
    // First parameter - Context
    // Second parameter - Layout for the row
    // Third - the Array of data

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, CoffeeShop);

    // Assign adapter to List
    setListAdapter(adapter);
}

@Override
protected void onListItemClick(ListView l, View v, int position, long id) {

    super.onListItemClick(l, v, position, id);

// ListView Clicked item index
    int itemPosition = position;

    // ListView Clicked item value
    String itemValue = (String) l.getItemAtPosition(position);

    content.setText("Click : \n  Position :" + itemPosition
            + "  \n  ListItem : " + itemValue);

    }
}