TextView tv;
int eFood;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);
    Intent i = getIntent();
    tv = (TextView)findViewById(R.id.textView2);
    eFood = i.getIntExtra("eFood",0);
    String efoodStr = "" + eFood;
    tv.setText(efoodStr);
}