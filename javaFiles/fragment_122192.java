@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (EditText)findViewById(R.id.editText);
        text2 = (EditText)findViewById(R.id.editText2);
        text = (TextView)findViewById(R.id.textView3);        
        // fNum = Integer.parseInt(text1.getText().toString()); // remove this line        
        // sNum = Integer.parseInt(text2.getText().toString()); // remove this line
        registerForContextMenu(text);

    }