@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


FrameLayout mFrame = (FrameLayout) findViewById(R.id.content);
        mFrame.addView(LayoutInflater.from(this).inflate(R.layout.activity_nav_test, mFrame, true));
}