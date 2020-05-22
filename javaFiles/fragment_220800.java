@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    // hi is enough
    EditText hi = findViewById(R.id.textView2);
    Bundle extras = getIntent().getExtras();
    if (extras != null) {
        boolean fromNo = getIntent().getExtras().getBoolean("FROM_NO", false); 
        //use of ternary to make it simple
        int sum = getIntent().getIntExtra(fromNo?"RESULT_SUM":"RESULT_SUMd", 0);
        hi.setText(String.valueOf(sum));
    }

 }