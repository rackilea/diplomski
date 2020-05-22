@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_layout);

    drawView = (DrawingView)findViewById(R.id.drawing);
    LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
    currPaint = (ImageButton)paintLayout.getChildAt(0);
}