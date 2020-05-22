class CustomListView extends ListView {

    private Paint mPaint = new Paint();
    private Paint mPaintBackground = new Paint();

    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(Color.RED);
        mPaintBackground.setColor(Color.CYAN);
    }       

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        // ListView's height
        final int currentHeight = getMeasuredHeight();
        // this will let you know the status for the ListView, fitting/not
        // fitting content
        final int scrolledHeight = computeVerticalScrollRange();
        if (scrolledHeight >= currentHeight || scrolledHeight == 0) {
            // there is no need to draw something(for simplicity I assumed that
            // if the adapter has no items i wouldn't draw something on the
            // screen. If you still do want the lines then pick a decent value
            // to simulate a row's height and draw them until you hit the
            // ListView's getMeasuredHeight)
            return;
        } else {
            // get the last drawn child
            final View lastChild = getChildAt(getChildCount() - 1);
            // values used to know where to start drawing lines
            final int lastChildBottom = lastChild.getBottom();
            // last child's height(use this to determine an appropriate value
            // for the row height)
            final int lastChildHeight = lastChild.getMeasuredHeight();
            // determine the number of lines required to fill the ListView
            final int nrOfLines = (currentHeight - lastChildBottom)
                    / lastChildHeight;
            // I used this to simulate a special color for the ListView's row background
            Rect r = new Rect(0, lastChildBottom, getMeasuredWidth(),
                    getMeasuredHeight());           
            canvas.drawRect(r, mPaintBackground);
            for (int i = 0; i < nrOfLines; i++) {
                canvas.drawLine(0, lastChildBottom + (i + 1) * lastChildHeight,
                        getMeasuredWidth(), lastChildBottom + (i + 1)
                                * lastChildHeight, mPaint);
            }
        }
    }

}