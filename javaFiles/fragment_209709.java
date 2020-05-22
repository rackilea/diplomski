@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_message);

    /****/
    TextView textView = (TextView) findViewById(R.id.display_message);
    textView.setTextSize(40);
    textView.setText(message);