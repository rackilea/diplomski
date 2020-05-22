public class MainActivity extends Activity implements SurfaceHolder.Callback {

    SurfaceView mSurfaceView;
    SurfaceHolder mSurfaceHolder;
    Camera mCamera;
    boolean mPreviewRunning;
    Button btncapture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncapture=(Button) findViewById(R.id.btncapture);
        mSurfaceView = (SurfaceView) findViewById(R.id.surface_camera);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        btncapture.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //take picture here
                mCamera.takePicture(null, null, mPictureCallback);
            }
        });
    }

    Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] imageData, Camera c) {

            Bitmap bitmap = BitmapFactory.decodeByteArray(imageData , 0, imageData .length);
            String file_path=saveToInternalSorage(bitmap);
            Toast.makeText(getApplicationContext(),"Image stored succesfully at "+file_path,Toast.LENGTH_LONG).show();
        }
    };

    private String saveToInternalSorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
         // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"marina1.jpg");

        FileOutputStream fos = null;
        try {           

            fos = new FileOutputStream(mypath);

       // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directory.getAbsolutePath();
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mCamera=Camera.open();


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int w,
            int h) {
        if (mPreviewRunning) {
            mCamera.stopPreview();
            }
            Camera.Parameters p = mCamera.getParameters();
            p.setPreviewSize(w, h);
            mCamera.setParameters(p);
            try {
            mCamera.setPreviewDisplay(holder);
            } catch (IOException e) {
            e.printStackTrace();
            }
            mCamera.startPreview();
            mPreviewRunning = true;

    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamera.stopPreview();
        mPreviewRunning = false;
        mCamera.release();

    }

}