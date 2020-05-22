@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.YOUR_LAY_OUT);
    Intent intent = getIntent();
    if(intent != null){
      String username = intent.getStringExtra("username");
      String password = intent.getStringExtra("password");
    }
}