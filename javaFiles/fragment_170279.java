public class MyListView extends ListView {

    private MyScroller mScroller;

    /* MyListView constructors here */

    public void awesomeScrollToPosition(int position, int duration) {

        if (getChildCount() == 0) {
            // Can't scroll without children (visible list items)
            return;
        }

        if (mScroller == null) {
            mScroller = new MyScroller();
        }

        if (mScroller.isRunning()) {
            mScroller.stop();
        }

        int firstPos = getFirstVisiblePosition();
        int lastPos = getLastVisiblePosition();

        if (!(firstPos <= position && position <= lastPos)) {
            // Can't scroll to an item outside of the visible range this easily
            return;
        }

        int targetPosition = position - firstPos;
        int targetTop = getChildAt(targetPosition).getTop();

        mScroller.start(targetTop, duration);
    }

    private class MyScroller implements Runnable {

        OverScroller mScroller;

        boolean mRunning;
        int mLastY;

        MyScroller() {
            mScroller = new OverScroller(getContext());
            mRunning = false;
        }

        void start(int y, int duration) {

            // start scrolling
            mLastY = 0;
            mScroller.startScroll(0, 0, 0, y, duration);

            mRunning = true;
            postOnAnimation(this);
        }

        boolean isRunning() {
           return mRunning;
        }

        @Override
        public void run() {

            boolean more = mScroller.computeScrollOffset();
            final int currentY = mScroller.getCurrY();

            // actual scrolling
            scrollListBy(currentY - mLastY);

            if (more) {
                mLastY = currentY;

                // schedule next run
                postOnAnimation(this);
            } else {
                stop();
            }
        }

        public void stop() {

            mRunning = false;
            removeCallbacks(this);
        }
    }
}