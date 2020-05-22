// e1 and e2 are not anymore inside any method, so they will be fields of the class
EditText e1; 
EditText e2;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView t = (TextView) findViewById(R.id.textView3);
    e1 = (EditText) findViewById(R.id.editText1);
    e2 = (EditText) findViewById(R.id.editText2);
}

// person method can use them without problems
private void person()
{
    String name = e1.getText();
    String phone = e2.getText();
}