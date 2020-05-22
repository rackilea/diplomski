@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    Button b = (Button) findViewById(R.id.button1);
    final LinearLayout test = (LinearLayout)findViewById(R.id.test);

    b.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            ImageView image = new ImageView(MainActivity.this);
            image.setImageResource(your_image_here);
            image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            test.addView(image);
        }
    });