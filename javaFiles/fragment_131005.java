@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    b = (Button) findViewById(R.id.button1);
    b.setOnClickListener(this);
    }