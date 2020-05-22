@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tips_2);

    btn = (Button) findViewById(R.id.bt);
    txv = (TextView) findViewById(R.id.tx);
    txv2 = (TextView) findViewById(R.id.tx2);
    public int mCounter=0;
    public Integer tx =15;


    btn.setOnClickListener(new View.OnClickListener() {


                               @Override
                               public void onClick(View v) {
                                   mCounter++;
                                   if(mCounter==tx){
                                      txv.setText(Integer.toString(mCounter));
                                       //reset the counter after 15 click 
                                       mCounter=0
                                   }

                               }



                           }


    );


}