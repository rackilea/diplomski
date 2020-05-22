protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tv01 = (TextView) findViewById(R.id.tv01);
    public void addCoffee(View v) {

    Total = Total + 2.20;
    tv01.setText(""+Total+"");
   }
   }