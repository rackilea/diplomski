@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


String[] myArray = {"biscuits", "laptops", "mice", "headphones", "macBook", "bottles", "something", "also something",
                    "this list is stupid", "and", "dumb", "and", "useless", "okay", "here it ends"};

    ListAdapter myListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, myArray);

    ListView myListView = (ListView) findViewById(R.id.myListView);

    myListView.setAdapter(myListAdapter);
}
}