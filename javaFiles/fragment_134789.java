import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

private GestureDetectorCompat mDetector;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mDetector = new GestureDetectorCompat(MainActivity.this, new SwipeGestureDetector());
}

@Override
public boolean onTouchEvent(MotionEvent motionEvent) {
    this.mDetector.onTouchEvent(motionEvent);
    return super.onTouchEvent(motionEvent);
}

@Override
public boolean dispatchTouchEvent(@NonNull MotionEvent ev) {
    super.dispatchTouchEvent(ev);
    return mDetector.onTouchEvent(ev);
}

/**
 * Swipe Gesture Detector Class for swipe detector.
 */
public class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e1 == null || e2 == null)
            return false;
        if(e1.getPointerCount() > 1 || e2.getPointerCount() > 1)
            return false;
        else {
            try {
                float diffX = e2.getX() - e1.getX();
                float diffY = e2.getY() - e1.getY();
                if(Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > 100 && Math.abs(velocityX) > 1000) {
                        if ((diffX > 0) || (diffX < 0)) {
//                                      nextActivity();

                                return true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            return false;
        }
    }
}