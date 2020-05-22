public class MainActivity extends Activity {

private String mFileUri;
private final Context mContext = this;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btnbutton1 = (Button) findViewById(R.id.button1);
    btnbutton1.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            Uri uri = createPictureFile();
            mFileUri = uri.getEncodedPath();
            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent, 100);
        }
    });
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 100 && resultCode == RESULT_OK) {
        if (mFileUri != null) {
            Intent intent = new Intent(mContext, SecondActivity.class);
            intent.putExtra("filepath", mFileUri);
            startActivity(intent);
        }
    }
}

private static File getOutputMediaFile(int type) {

    File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "DCIM/Camera");

    if (!mediaStorageDir.exists()) {
        if (!mediaStorageDir.mkdirs()) {
            return null;
        }
    }

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
    File mediaFile;
    if (type == 1) { // image
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
    } else if (type == 2) { // video
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + "VID_" + timeStamp + ".mp4");
    } else {
        return null;
    }

    return mediaFile;
}

public Uri createPictureFile() {
    String storageState = Environment.getExternalStorageState();
    if (storageState.equals(Environment.MEDIA_MOUNTED)) {
        File pictureDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        pictureDir = new File(pictureDir, "MyApp");

        // Create the storage directory if it does not exist
        if (!pictureDir.exists()) {
            if (!pictureDir.mkdirs()) {
                Log.d("user", "failed to create directory");
                return null;
            }
        }

        //Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = pictureDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg";
        File imageFile = new File(fileName);

        // Convert to URI and return
        return Uri.fromFile(imageFile);
    } else {
        Log.d("user", "No media mounted");
        return null;
    }
}
}