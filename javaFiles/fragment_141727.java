@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (!isCameraAvailable()) {
        // Cancel request if there is no rear-facing camera.
        cancelRequest();
        return;
    }

    // Hide the window title.
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.main);

    mAutoFocusHandler = new Handler();

    // Create and configure the ImageScanner;
    setupScanner();

    // Create a RelativeLayout container that will hold a SurfaceView,
    // and set it as the content of our activity.
    mPreview = new CameraPreview(this, this, autoFocusCB);
    LinearLayout zbarLayout = (LinearLayout) findViewById(R.id.zbar_layout_area);
    mPreview.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    zbarLayout.addView(mPreview);
}