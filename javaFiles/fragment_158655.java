@Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_view);
            Intent intent = getIntent();

            //create your model data
            ListModel listmodel = new ListModel();
            listmodel.setName("Hiiiiii");

            //add your model to the collection
            list.add(listmodel);

            //then you can set your adapter
            listView = (ListView) findViewById(R.id.list_view);
            adapter = new CustomListAdapter(this, list);
            listView.setAdapter(adapter);

        }