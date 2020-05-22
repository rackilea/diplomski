@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ArrayList<String> fileNames = new ArrayList<String>();
    fileNames.add("Test1.mp3");
    fileNames.add("Test2.mp3");

    final ListView listView = (ListView) findViewById (R.id.mainListView);
    ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fileNames);
    listView.setAdapter(listAdapter);

    listView.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
            Toast toast = Toast.makeText(getApplicationContext(), 
                    (String)arg0.getItemAtPosition(position), Toast.LENGTH_SHORT);
            toast.show();   
        }
    });
}