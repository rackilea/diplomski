ListView lv;
DatabaseHelper db;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ...

    lv = (ListView) findViewById(R.id.list_view);
    db = new DatabaseHelper(this);
    ...
}