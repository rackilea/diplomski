protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_client_list);

    listaClientes = (ListView) findViewById((R.id.listView));
    Bundle bundle = getIntent().getExtras(); //get the intent and data  passed
    //next check that bundle is not null
    if (bundle != null) {
        String name = bundle.getString("VariableName"); 
        //try loging out the value
        Log.i("Name", name);
    }

}