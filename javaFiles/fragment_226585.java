@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    DisplayMetrics dm = new DisplayMetrics();
    WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
    wm.getDefaultDisplay().getMetrics(dm);
    int mainHeight = dm.heightPixels;
    Log.i(TAG, "mainHeight: " + mainHeight);

    FrameLayout flLayout = findViewById(R.id.fl_container);
    flLayout.setMinimumHeight(mainHeight / 2); // <-- Set pixel value, not dp!
}