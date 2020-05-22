Button btn1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main); <---- activity_main
    btn1 = (Button) findViewById(R.id.button1);
}