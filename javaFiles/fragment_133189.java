public class ResistorView extends View {
    private Path mSymbol;
    private Paint mPaint;

    //...Override Constructors...
    public ResistorView(Context context) {
        super(context);
        init();
    }

    public ResistorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mSymbol = new Path();
        mPaint = new Paint();
        //...Your code here to set up the path,
        //...allocate objects here, never in the drawing code.
    }

    //...Override onMeasure()...
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //Use this method to tell Android how big your view is
        setMeasuredDimension(width, height);
    }

    //...Override onDraw()...
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(mSymbol, mPaint);
    }        

}