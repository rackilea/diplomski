public class FourDirectionLayout extends ViewGroup {
    private GestureDetector mDetector;
    private Scroller mScroller;
    private final String[] TEXTS = {
            "left view, left swipe only",
            "right view, right swipe only",
            "top view, top swipe only",
            "bottom view, bottom swipe only",
            "central view, swipe to the left, right, top or bottom",
    };
    private final int[] COLORS = {
            0xaa0000ff, 0xaa0000ff, 0xaaff0000, 0xaaff0000, 0xaa00ff00
    };
    private final int[] PACKED_OFFSETS = {
            -1, 0, 1, 0, 0, -1, 0, 1, 0, 0
    };

    public FourDirectionLayout(Context context) {
        super(context);
        for (int i = 0; i < TEXTS.length; i++) {
            TextView tv = new TextView(context);
            tv.setTag(i);
            tv.setTextSize(32);
            tv.setTypeface(Typeface.DEFAULT_BOLD);
            tv.setTextColor(0xffeeeeee);
            tv.setText(TEXTS[i]);
            tv.setBackgroundColor(COLORS[i]);
            addView(tv);
        }
        mDetector = new GestureDetector(context, mListener);
        mScroller = new Scroller(context);
    }

    private OnGestureListener mListener = new SimpleOnGestureListener() {
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (!mScroller.isFinished()) {
                return false;
            }
            int sx = getScrollX();
            int sy = getScrollY();
            int w = getWidth();
            int h = getHeight();
            int DURATION = 500;
            // check if horizontal/vertical fling
            if (Math.abs(velocityX) > Math.abs(velocityY)) {
                if (sy != 0 || velocityX * sx < 0) {
                    return false;
                }
//                DURATION = (int) (1000 * w / Math.abs(velocityX));
                int distance = velocityX < 0? w : -w;
                mScroller.startScroll(sx, sy, distance, 0, DURATION);
            } else {
                if (sx != 0 || velocityY * sy < 0) {
                    return false;
                }
//                DURATION = (int) (1000 * h / Math.abs(velocityY));
                int distance = velocityY < 0? h : -h;
                mScroller.startScroll(sx, sy, 0, distance, DURATION);
            }
            invalidate();
            return true;
        }
    };

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int cnt = getChildCount();
        for (int i = 0; i < cnt ; i++) {
            View child = getChildAt(i);
            int idx = (Integer) child.getTag() << 1;
            int xOffset = (r - l) * PACKED_OFFSETS[idx];
            int yOffset = (b - t) * PACKED_OFFSETS[idx + 1];
            child.layout(l + xOffset, t + yOffset, r + xOffset, b + yOffset);
        }
    }
}