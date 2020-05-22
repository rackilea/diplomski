LinearLayout someLinearLayout;
int setImage=R.drawable.ic_launcher;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    someLinearLayout=(LinearLayout) findViewById(R.id.image1);
    ImageView imageView = new ImageView(this);
    LinearLayout.LayoutParams vp =  new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    imageView.setLayoutParams(vp);        
    imageView.setImageResource(setImage);
    someLinearLayout.addView(imageView);
}