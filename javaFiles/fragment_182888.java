@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
    clicks=0;
    isonthread=false;
    list = (ListView) findViewById(R.id.list);