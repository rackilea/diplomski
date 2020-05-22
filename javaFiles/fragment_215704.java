super.onCreate(savedInstanceState);
setContentView(R.layout.activity_display_message);

Intent intent = getIntent();
String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

TextView textView = (TextView)findViewById(R.id.my_text_view);
textView.setTextSize(40);
textView.setText(message);