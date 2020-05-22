protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_vraag1);

    a = (Button) findViewById(R.id.button1);
    a.setOnClickListener(this);

    b = (Button) findViewById(R.id.button2);
    b.setOnClickListener(this);

    c = (Button) findViewById(R.id.button3);
    c.setOnClickListener(this);

    d = (Button) findViewById(R.id.button4);
    d.setOnClickListener(this);

    e = (Button) findViewById(R.id.button5);
    e.setOnClickListener(this);  

}