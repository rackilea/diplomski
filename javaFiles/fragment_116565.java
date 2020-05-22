public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.crop_test_layout);
    imageView = (ImageView)findViewById(R.id.android_image);
    cropBox = new CropBox(this, imageView);
    relativeLayout = (RelativeLayout)findViewById(R.id.crop_test_layout);
    relativeLayout.addView(cropBox);
}