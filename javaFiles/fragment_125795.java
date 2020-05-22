private static final int CAMERA_REQUEST = 1888;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
}

protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
        final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
               .putExtra(Intent.EXTRA_STREAM,
                Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(),
                        (Bitmap) data.getExtras().get("data"), "title", null)
               ))
               .setType("image/jpeg");
        startActivity(intent);
    }
}