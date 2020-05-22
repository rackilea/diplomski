int imageWidth;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.phase);
    onWindowFocusChanged(hasWindowFocus());
    Log.d("log", Integer.toString(imageWidth))}

@Override
public void onWindowFocusChanged(boolean hasFocus){
    int width=phaseimage.getWidth();
    int height=phaseimage.getHeight();
    imageWidth = width;
    }