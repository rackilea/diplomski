@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_main_activity_paper);


    text1 = (TextView) findViewById(R.id.editText1);

    String s = null;
    try{
        Bundle b = this.getIntent().getExtras();
        s= b.getString("my_key");

        }catch(Exception e){
            s="";
            e.printStackTrace();
        }finally{
            text1.setText(s.toString());
        }
    title1 = (TextView) findViewById(R.id.editText3);
    save1 = (Button) findViewById(R.id.button3);
    update1 = (Button) findViewById(R.id.button5);

    save1.setOnClickListener(this);
    update1.setOnClickListener(this);

}