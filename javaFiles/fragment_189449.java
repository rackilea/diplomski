@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ListView listView = (ListView) findViewById(R.id.list_item1);

    List<Services> services = gerarServices();


    ArrayAdapter<Services> servicesAdapter = new ArrayAdapter<Services>(this, android.R.layout.simple_list_item_1, services);
    listView.setAdapter(servicesAdapter);

}