public class CropBox extends View {

    private static final int CROP_BOX_START_X = 5;
    private static final int CROP_BOX_START_Y = 5;
    private static final int CROP_BOX_END_X = 305;
    private static final int CROP_BOX_END_Y = 105;

    private static final int DRAG_SQUARE = 75;

    public ImageView mImageView;
    boolean mIsFirstClick = false;

    private Paint paint = new Paint();
    private Rect mRect;

    public CropBox(Context context, ImageView aBaseView) {
        super(context);
        mImageView = aBaseView;
        mRect = new Rect(CROP_BOX_START_X, CROP_BOX_START_Y, CROP_BOX_END_X, CROP_BOX_END_Y);
        setOnTouchListener(new Crop());
    }

    public CropBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public void onDraw(Canvas canvas) {

        paint.setStrokeWidth(2);

        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(mRect, paint);

        canvas.drawLine(mRect.right-DRAG_SQUARE, mRect.bottom-DRAG_SQUARE, 
                mRect.right, mRect.bottom-DRAG_SQUARE, paint);

        canvas.drawLine(mRect.right-DRAG_SQUARE, mRect.bottom-DRAG_SQUARE, 
                mRect.right-DRAG_SQUARE, mRect.bottom, paint);
    }

    class Crop implements OnTouchListener {

        private static final int NONE = 0;
        private static final int BOX_DRAG = 1;
        private static final int BORDER_DRAG = 2;

        private int mode = NONE;

        private PointF start = new PointF();

        public boolean onTouch(View view, MotionEvent event) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)view.getLayoutParams();

            switch(event.getAction() & MotionEvent.ACTION_MASK) {

                case MotionEvent.ACTION_DOWN:
                    start.set(event.getX(), event.getY());

                    if((event.getX() <= mRect.right && event.getX() >=(mRect.right - DRAG_SQUARE)) 
                            && (event.getY() >= mRect.top && event.getY() >=(mRect.bottom - DRAG_SQUARE))){
                        mode = BORDER_DRAG;
                        mIsFirstClick = false;
                    }
                    else if(mRect.contains((int)event.getX(), (int)event.getY())) {
                        mode = BOX_DRAG;
                        if (mIsFirstClick){
                            mRect = new Rect(CROP_BOX_START_X, CROP_BOX_START_Y, 
                                    CROP_BOX_END_X, CROP_BOX_END_Y);
                            mIsFirstClick = false;  
                        } else {
                            mIsFirstClick = true;   
                        }
                    }
                    else{
                        mode = NONE;
                        mIsFirstClick = true;
                    }
                    break;

                case MotionEvent.ACTION_UP:
                    mode = NONE;
                    break;

                case MotionEvent.ACTION_MOVE:
                    mIsFirstClick = false;
                    if(mode == BOX_DRAG) {
                        layoutParams.leftMargin = (int)event.getX() - (int)start.x + view.getLeft();
                        layoutParams.topMargin = (int)event.getY() - (int)start.y + view.getTop();
                    }
                    else if(mode == BORDER_DRAG) {
                        if (event.getX() > view.getLeft() && event.getY() > view.getTop()){
                            mRect.right = (int) event.getX();
                            mRect.bottom = (int) event.getY();
                        }
                    }
                    while(layoutParams.topMargin + 5 < mImageView.getTop())
                        layoutParams.topMargin++;
                    while(layoutParams.leftMargin + mRect.right > mImageView.getRight())
                        layoutParams.leftMargin--;
                    while(layoutParams.topMargin + mRect.bottom > mImageView.getBottom())
                        layoutParams.topMargin--;
                    while(layoutParams.leftMargin + 5 < mImageView.getLeft())
                        layoutParams.leftMargin++;
                    break;
            }
            view.setLayoutParams(layoutParams);
            invalidate();
            return true;
        }
    }
}