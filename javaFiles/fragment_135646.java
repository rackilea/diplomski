@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_view);

   ListView listview = (ListView)findViewById(R.id.listview);

    String[] arrayTitles = formattedTitles.split(",");
    String[] arrayDescriptions = formattedDescriptions.split(",");

        CustomAdapter arrayAdapter = new CustomAdapter(ListViewActivity.this, arrayTitles,arrayDescriptions);
        listview.setAdapter(arrayAdapter);
}