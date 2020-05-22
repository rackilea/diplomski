protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main3);

    v1=(ImageView)findViewById(R.id.imageViewnew);
    v2=(ImageView)findViewById(R.id.imageViewupdate);
    b1=(Button)findViewById(R.id.cameranew);
    b2=(Button)findViewById(R.id.cameraupp);


    String IVX = "abcdefghijklmnop"; // 16 lenght - not secret
    String SECRET_KEY = "secret1234567890"; // 16 lenght - secret

    SimpleStorageConfiguration configuration = new SimpleStorageConfiguration.Builder()
            .setEncryptContent(IVX, SECRET_KEY)
            .build();

    if (SimpleStorage.isExternalStorageWritable()) {
        storage = SimpleStorage.getExternalStorage();
    }
    else {
        storage = SimpleStorage.getInternalStorage(getApplicationContext());
    }

    SimpleStorage.updateConfiguration(configuration);

    imagePath = "image" + ".png";
    boolean dirExists = storage.isDirectoryExists("savedimages");

    if(dirExists==true)
    {
        System.out.println("Directoy Already Created");
    }
    else {
        storage.createDirectory("savedimages", true);
    }

    boolean fileExists = storage.isFileExist("savedimages",imagePath);

    if(fileExists==true) {
        System.out.println("File Already Created");
    }
    else {
        storage.createFile("savedimages", imagePath, " ");
    }

    ff=storage.getFile("savedimages",imagePath);

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            outputFileUri = Uri.fromFile(ff);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            startActivityForResult(intent, CAMERA_REQUEST);

        }
    });
}
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

        BitmapFactory.Options options=new BitmapFactory.Options();
        final Bitmap b=BitmapFactory.decodeFile(ff.toString(),options);
        v2.setImageBitmap(b);

        storage.createFile("savedimages",imagePath,b);

    }
}}