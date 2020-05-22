protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);
    Intent intent=getIntent();
    String a = intent.getStringExtra(MainActivity.KEY);
    TextView tv = (TextView) findViewById(R.id.textView1);
    tv.setText(a);
}