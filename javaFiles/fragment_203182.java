public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  fillData();
  ArrayAdapter boxAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(products.name)));

  ListView lvMain = (ListView) findViewById(R.id.lvMain);
  lvMain.setAdapter(boxAdapter);
}

void fillData() {
 String temp;
 for (int i = 0; i <columnTags.length; i++) {
   temp = columnTags[i];
    products.add(new Product(temp, i * 100,i * 553, false));
  }
}