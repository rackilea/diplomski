import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ViewPagerSwipeControlled extends ViewPager {

    private boolean swipeEnabled = true;

    public ViewPagerSwipeControlled(Context context) {
        super(context);
    }

    public ViewPagerSwipeControlled(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSwipeEnabled(boolean swipeEnabled) {
        this.swipeEnabled = swipeEnabled;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return swipeEnabled;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (swipeEnabled) {
            return super.onTouchEvent(ev);
        } else {
            return true;
        }
    }

}