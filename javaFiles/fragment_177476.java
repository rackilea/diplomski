@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (!OpenCVLoader.initDebug()) {
        Log.d(TAG, "OpenCVLoader.initDebug() - ERROR");
    } else {
        Log.d(TAG, "OpenCVLoader.initDebug() - OK");
    }

    mImageView = (ImageView) findViewById(R.id.source_image_view);
    mProcessButton = (Button) findViewById(R.id.process_button);

    mProcessButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Bitmap bmSource = BitmapFactory.decodeResource(getResources(), R.drawable.test);
            Bitmap bmRoi = findRoi(bmSource);

            mImageView.setImageBitmap(bmRoi);
        }
    });
}