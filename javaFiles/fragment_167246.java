private int item_width = 70; // Width in pixel

    public void scrollLeft()
    {
        mNextX -= item_width;
        mScroller.fling(mNextX, 0, -50, 0, 0, mMaxX, 0, 0);
        requestLayout();
    }

    public void scrollRight()
    {
        mNextX += item_width;
        mScroller.fling(mNextX, 0, -50, 0, 0, mMaxX, 0, 0);
        requestLayout();
    }