public class MainActivity extends ActionBarActivity {
  public final static String EXTRA_MESSAGE = "File_name";
  private Camera mCamera; 

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // Create an instance of Camera
      mCamera = getCameraInstance();

      // Create our Preview view and set it as the content of our activity.
      CameraPreview mPreview = new CameraPreview(this, mCamera);
      FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
      preview.addView(mPreview);

      // Add a listener to the Capture button
      Button captureButton = (Button) findViewById(R.id.button_capture);
      captureButton.setOnClickListener(new View.OnClickListener() {

         @Override
           public void onClick(View v) {
            // get an image from the camera
            mCamera.takePicture(null, null, mPicture);
           }
         }
      );
  }

  ...