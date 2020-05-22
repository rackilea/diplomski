@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lifecycle);

    numc++;
    Log.d("STATE", "onCreate executed");
    displayCount();


    TextView t1= new TextView(this);
    t1.setText("onCreate executed");
    linear.addView(t1);
}

@Override
public void onResume() {
    super.onResume();


    numr++;
    Log.d("STATE", "onRes executed" + numr);
    displayCount();


    TextView t2= new TextView(this);
    linear.addView(t2);
    t2.setText("onResume executed");
}    
@Override
public void onPause() {
    super.onPause();


    nump++;
    Log.d("STATE", "onPause executed" + nump);
    displayCount();


    TextView t3= new TextView(this);
    linear.addView(t3);
    t3.setText("onPause executed");
    Log.d("INCREMENT", String.valueOf(linear.getChildCount()));

}