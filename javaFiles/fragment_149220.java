@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sub);

    // Intent uitlezen
    Bundle extras = getIntent().getExtras();

    int resId = extras.getInt("witte_tulp_small");
    ImageView image = (ImageView) findViewById(R.id.image);
    image.setImageResource(resId);
}