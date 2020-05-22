public class MainActivity extends AppCompatActivity {

        private static final int REQUEST_RUNTIME_PERMISSION = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

             checkPremission();
            }


         void checkPremission() {
                //select which permission you want
                final String permission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
                    // if in fragment use getActivity()
                if (ContextCompat.checkSelfPermission(ActivityName.this, permission)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(ActivityName.this, permission)) {

                    } else {
                        ActivityCompat.requestPermissions(ActivityName.this, new String[]{permission}, REQUEST_CAMERA_PERMISSION);
                    }
                } else {
                    // you have permission go ahead
                    File ed = Environment.getExternalStorageDirectory();
                    File[] fs = ed.listFiles();
                    Log.i(ed.getAbsolutePath(), (fs != null ? fs.length : "no") + " files found");
                }
            }

            @Override
            public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                switch (requestCode) {
                    case REQUEST_RUNTIME_PERMISSION:
                        final int numOfRequest = grantResults.length;
                        final boolean isGranted = numOfRequest == 1
                                && PackageManager.PERMISSION_GRANTED == grantResults[numOfRequest - 1];
                        if (isGranted) {
                            // you have permission go ahead
                           File ed = Environment.getExternalStorageDirectory();

                           File[] fs = ed.listFiles();
                           Log.i(ed.getAbsolutePath(), (fs != null ? fs.length : "no") + " files found");
                        }else{
                            // you dont have permission show toast
                        }
                        break;
                    default:
                        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                }
            }
}