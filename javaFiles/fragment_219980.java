import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

public class ItemTouchListener implements View.OnTouchListener {
    private int mSlop;
    private View mView;
    private float mDownX, mDownY;
    private boolean mSwiping;
    private int mSwipingSlop;
    private VelocityTracker mVelocityTracker;
    private float mTranslationX;

    public ItemTouchListener(View view) {
        ViewConfiguration vc = ViewConfiguration.get(view.getContext());
        mSlop = vc.getScaledTouchSlop();
        mView = view;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        // offset because the view is translated during swipe
        motionEvent.offsetLocation(mTranslationX, 0);
        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                mDownX = motionEvent.getRawX();
                mDownY = motionEvent.getRawY();
                return true;
            }
            case MotionEvent.ACTION_UP: {

                // if needed, implement part of limit swipe logic also here

                if (mVelocityTracker == null) {
                    break;
                }
                mVelocityTracker.addMovement(motionEvent);
                mVelocityTracker.computeCurrentVelocity(1000);
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                mTranslationX = 0;
                mDownX = 0;
                mDownY = 0;
                mSwiping = false;
                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                if (mVelocityTracker == null) {
                    break;
                }
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                mTranslationX = 0;
                mDownX = 0;
                mDownY = 0;
                mSwiping = false;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                if (mVelocityTracker == null) {
                    break;
                }
                mVelocityTracker.addMovement(motionEvent);
                float deltaX = motionEvent.getRawX() - mDownX;
                float deltaY = motionEvent.getRawY() - mDownY;
                if (Math.abs(deltaX) > mSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2) {
                    mSwiping = true;
                    mSwipingSlop = (deltaX > 0 ? mSlop : -mSlop);
                    // cancel view's touch
                    MotionEvent cancelEvent = MotionEvent.obtain(motionEvent);
                    cancelEvent.setAction(MotionEvent.ACTION_CANCEL |
                            (motionEvent.getActionIndex() << MotionEvent.ACTION_POINTER_INDEX_SHIFT));
                    cancelEvent.recycle();
                }
                if (mSwiping) {

                    // limit deltaX here: this will keep the swipe up to desired point 

                    mTranslationX = deltaX;
                    mView.setTranslationX(deltaX - mSwipingSlop);
                    return true;
                }
                break;
            }
        }
        return false;
    }
}