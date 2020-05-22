public class UploadImageActivity extends AppCompatActivity implements View.OnClickListener, UrlReceiver {

    CloudStorageDatabaseUtils databaseUtils = new CloudStorageDatabaseUtils();
    String downloadUrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        Button upload = findViewById(R.id.button_upload);

        upload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_upload:
                File rootStorage = Environment.getExternalStorageDirectory();
                File exactlyFile = new File(rootStorage.toString() + "/download/q1.jpeg");//or whatever

                databaseUtils.uploadImage("/example1/" + exactlyFile.getName(), exactlyFile);
                databaseUtils.getDownloadURL("/example1/" + exactlyFile.getName(), this);

        }
    }

    @Override
    public void onUrlReceived(String url) {
        if (url != null) {
            downloadUrl = url;
            Log.d("MyS", "url: " + url);
        }
    }
}