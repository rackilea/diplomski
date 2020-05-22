LinearLayout mylay;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.yess);
    mylay=(LinearLayout)findViewById(R.id.mylay);
    Thread timer = new Thread(){