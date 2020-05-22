Uri picUri;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_snap_camera);
    String imageFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/picture.jpg";  
    File imageFile = new File(imageFilePath); 
    picUri = Uri.fromFile(imageFile); // convert path to Uri        
    intent.putExtra( MediaStore.EXTRA_OUTPUT,  picUri );
    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
}