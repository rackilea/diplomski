public class LockableViewPager extends ViewPager {

    private boolean swipeable;

    public LockableViewPager(Context context) {
        super(context);
    }

    public LockableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.swipeable = true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.swipeable && super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.swipeable && super.onTouchEvent(event);
    }

    public void setSwipeable(boolean swipeable) {
        this.swipeable = swipeable;
    }
}