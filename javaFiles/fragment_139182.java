public class CameraActivity extends ActionBarActivity {

//    private static final int ACTION_TAKE_IMAGE = 1;

    Button btnImage;
    ImageView imageView;
    File image;
    String picturePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imageView = (ImageView) findViewById(R.id.imageView);

        btnImage = (Button) findViewById(R.id.buttonCapture);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cameraIntent = new Intent(
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                //Create folder
                File imagesFolder = new File(
                        Environment.getExternalStorageDirectory(), "Vipul/image");
                imagesFolder.mkdirs();

                //Asign name for image
                String fname = "Pic-" + System.currentTimeMillis() + ".png";
                image= new File(imagesFolder, fname);

                Uri uriSavedImage = Uri.fromFile(image);

                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);

                //launch camera app with result code (forResult)
                startActivityForResult(cameraIntent, 1);

            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap bitmap;

            BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

            picturePath=image.getAbsolutePath();

            bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(), bitmapOptions);

            imageView.setImageBitmap(bitmap);
        }
    }
}