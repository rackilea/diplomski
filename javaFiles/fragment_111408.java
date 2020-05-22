@Override
    protected void onCreate(Bundle iCicle) {
        super.onCreate(iCicle);
        //listItems=BookingList.getListAsString();      returns ArrayList of strings. this is what I normally use...
        setContentView(R.layout.activity_main3);
        list = (ListView) findViewById(R.id.Bookings);
        listItems = new ArrayList<>();
        listItems.add("foo");
        listItems.add("boo");
        listItems.add("goo");

        Log.d("ITEMLIST", "GOT LIST");
        for (String item : listItems)
            Log.d("ITEMLIST", item);

        if (listItems != null) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
            list.setAdapter(adapter);
        }

    }