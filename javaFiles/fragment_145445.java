private GestureDetector detector;  
private ImageView mImageView;

@Override  
public void onCreate(Bundle savedInstanceState) {  
  super.onCreate(savedInstanceState);  
  detector = new GestureDetector(this, new MyGesturesListener());  
  // TODO find your image view
  mImageView.setOnTouchListener(new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            detector.onTouchEvent(event);
            return true;
        }
    });
}