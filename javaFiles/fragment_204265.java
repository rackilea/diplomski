import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Spinner;

/**
 * Version of the Spinner class which doesn't open the popup on swipe
 */
public class SpinnerNoSwipe extends Spinner {

    private GestureDetector mGestureDetector;

    public SpinnerNoSwipe(Context context) {
        super(context);
        setup();
    }

    public SpinnerNoSwipe(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public SpinnerNoSwipe(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return performClick();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return true;
    }
}