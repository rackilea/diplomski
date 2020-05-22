@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);

    Input = (EditText) findViewById(R.id.Input);
    Text = (TextView) findViewById(R.id.Text); //added
    dbHandler = new Database(this, null, null, 1);
    // printDatabase();

}