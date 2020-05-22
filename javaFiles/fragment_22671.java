TextView mytextview;

@Override
protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_main);
    mytextview = (TextView) findViewById(R.id.textView1);
    mytextview.setText("write executed");
}