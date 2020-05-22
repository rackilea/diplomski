@Override
protected void onCreate(Bundle savedInstanceState) {

    setContentView(R.layout.activity_splash_activity_temp);
    ImageView imageView = (ImageView) findViewById(R.id.splash_logo);
    super.setLogo(imageView,this);
    super.onCreate(savedInstanceState);

}