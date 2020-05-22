UserDBHelper mydb;

@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_third);
    mydb = new UserDBHelper(this);
    //^^^^^^^^^^^^^^^^^^^^^
    ed1 = (EditText)findViewById(R.id.E1);
    ed2 = (EditText)findViewById(R.id.E2);
    ed3 = (EditText)findViewById(R.id.E3);
    B1  = (Button) findViewById(R.id.addB);
}