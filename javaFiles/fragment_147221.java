public class ZoomableTextView extends AppCompatTextView/*This is why the AppCompat dependency is needed*/ {
    private float textSize,
            textScale;
    private Scaler s;
    private ScaleListener listener;
    public ZoomableTextView(Context context) {
        super(context);
        init();
    }

    public ZoomableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ZoomableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        listener = new ScaleListener();
        s = new Scaler(getContext(), listener);
        textSize = getTextSize();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
        if(ev.getPointerCount() == 2){
            s.onTouchEvent(ev);
        }
        return true;
    }

    class ScaleListener implements ScaleGestureDetector.OnScaleGestureListener{

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            textScale *= detector.getScaleFactor();

            if(textScale > 2) textScale = 2;//Limit to your liking
            else if(textScale < 0.3f) textScale = 0.3f;//Limit to your liking
            textScale = (textScale * 100) / 100;//jitter-protection
            if(textScale < 0.3f) textScale = 0.3f;
            if(textScale > 2) textScale = 2;

            setTextSize(textSize * textScale);
            setPivotX(detector.getFocusX());
            setPivotY(detector.getFocusY());
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {return true;}

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {}
    }

    class Scaler extends ScaleGestureDetector {
        public Scaler(Context context, OnScaleGestureListener listener) {
            super(context, listener);
        }

        @Override
        public float getScaleFactor() {//Leave this method empty.
            return super.getScaleFactor();
        }
    }
}