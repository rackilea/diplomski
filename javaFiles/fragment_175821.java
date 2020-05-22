Button button1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_layout_that_contains_button1);

    button1 = (Button) findViewById(R.id.Button1);
    button1.setOnClickListener(onClickListener);
}