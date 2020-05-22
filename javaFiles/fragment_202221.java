private ImageButton mImageButton = null;

public void onCreate(Bundle savedInstanceState) {
  Log.d(AntengoApplication.LOG_TAG, "BrowsePicture onCreate");
  super.onCreate(savedInstanceState);
  setContentView(R.layout.layout_post);

  mImageButton = (ImageButton) findViewById(R.id.post_image);
  //do something with mImageButton
}

@Override
protected void onResume() {
  super.onResume();
  mImageButton = (ImageButton) findViewById(R.id.post_image);
  mImageButton.setImageURI(selectedImageUri);
}