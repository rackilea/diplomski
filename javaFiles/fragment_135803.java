//https://stackoverflow.com/questions/13477820/android-vertical-viewpager

public class VerticalViewPager extends ViewPager {

public VerticalViewPager(Context context) {
    super(context);
    init();
}

public VerticalViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
}

private void init() {
    setPageTransformer(true, new VerticalPageTransformer());
    setOverScrollMode(OVER_SCROLL_NEVER);
}

private MotionEvent swapXY(MotionEvent ev) {
    float width = getWidth();
    float height = getHeight();

    float newX = (ev.getY() / height) * width;
    float newY = (ev.getX() / width) * height;

    ev.setLocation(newX, newY);
    return ev;
}

@Override
public boolean onInterceptTouchEvent(MotionEvent ev) {
    boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
    swapXY(ev);
    //https://stackoverflow.com/questions/15365915/viewpager-nested-in-viewpager
    int action = ev.getAction();
    switch (action) {
        case MotionEvent.ACTION_UP:
            this.getParent().requestDisallowInterceptTouchEvent(true);
            break;
        case MotionEvent.ACTION_DOWN:
            this.getParent().requestDisallowInterceptTouchEvent(true);
            break;
        case MotionEvent.ACTION_MOVE:
            this.getParent().requestDisallowInterceptTouchEvent(true);
            break;
    }
    return intercepted;
}

@Override
public boolean onTouchEvent(MotionEvent ev) {
    return super.onTouchEvent(swapXY(ev));
}

}