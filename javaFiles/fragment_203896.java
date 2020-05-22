@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //add this two lines to your code to hide the system bar
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);

    setContentView(R.layout.activity_main);

    //this hides the navigation bar at the bottom of your device
    hideNavigationBar();

    final Button ShootLeft= findViewById(R.id.ShootLeft);
    Button ShootRight= findViewById(R.id.ShootRight);
    ShootLeft.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v){
        Log.d("Button","ShootLeft");
    }});
    ShootRight.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v){
        Log.d("Button","ShootRight");
    }});
}