public class DrawView extends View implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private GestureDetectorCompat g1;

    public DrawView(final Context context) {
        super(context);

        g1 = new GestureDetectorCompat(getContext(), this);
        g1.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        g1.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        setXandY(e.getX(), e.getY());
        Log.v("id2","message2");
        return false;
    }
}