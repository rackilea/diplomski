Button button1;
Button button2;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    button1 = findViewById(R.id.button1);
    button2 = findViewById(R.id.button2);

    button1.setOnClickListener(this);
    button2.setOnClickListener(this);

}