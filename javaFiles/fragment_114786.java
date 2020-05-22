public class CustomViewPager extends ViewPager {
private boolean swipeable = false;

public CustomViewPager(Context context) {
    super(context);
}

public CustomViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
}

// Call this method in your motion events when you want to disable or enable
// It should work as desired.
public void setSwipeable(boolean swipeable) {
    this.swipeable = swipeable;
}

@Override
public boolean onInterceptTouchEvent(MotionEvent arg0) {
    return (this.swipeable) ? super.onInterceptTouchEvent(arg0) : false;
}