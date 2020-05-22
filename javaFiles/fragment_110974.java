@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mapoverviewlayout);

    // Initialize the map.
    mMapView = (MapView) findViewById(R.id.mapview);    
    mMapView.setBuiltInZoomControls(true);      

    // Obtain the view flipper.
    mFlipper = (ViewFlipper)findViewById(R.id.mapviewflipper);        

    // Initialize the animations.       
    Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();          
    int h2 = display.getHeight() / 2;     
    int w2 = display.getWidth() / 2;

    mInMapAnimation = new Rotate3dAnimation(-90, 0, w2, h2, 0.0f, false);
    mInMapAnimation.setDuration(500);
    mInMapAnimation.setStartOffset(500);

    mInStgAnimation = new Rotate3dAnimation(90, 0, w2, h2, 0.0f, false);
    mInStgAnimation.setDuration(500);
    mInStgAnimation.setStartOffset(500);

    mOutMapAnimation = new Rotate3dAnimation(0, -90, w2, h2, 0.0f, false);
    mOutMapAnimation.setDuration(500);

    mOutStgAnimation = new Rotate3dAnimation(0, 90, w2, h2, 0.0f, false);
    mOutStgAnimation.setDuration(500);

}