public class MainActivity extends Activity { 
public ImageView iv = null;
public void onCreate(....) {
    setContentView( ... ); 
    iv = findViewById(....);
}

public class OnSwipeTouchListener extends MainActivity implements OnTouchListener {
    //public ImageView iv from MainActivity
    public OnSwipeTouchListener (Context ctx){
        gestureDetector = new GestureDetector(ctx, new GestureListener());
    }

    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            iv.setImageResource(R.drawable.funny); //iv is accessable, you may also use a constructor to pass the reference.
            return super.onDoubleTap(e);
        }
    }
}