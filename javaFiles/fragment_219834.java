@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);

    ArrayList<HashMap<String, String>> itemsList = new ArrayList<HashMap<String, String>>();

    ListView listView = (ListView) findViewById(R.id.listView);

    for (int i = 0; i < 5; i++) {

        // creating new HashMap
        HashMap<String, String> map = new HashMap<String, String>();

        // adding each child node to HashMap key =&gt; value
        map.put("key1", "value1");
        map.put("key2", "value2");

        // adding HashList to ArrayList
        itemsList.add(map);
    }

    ListAdapter listAdapter = new ListAdapter(this, itemsList);
    listView.setAdapter(listAdapter);
}