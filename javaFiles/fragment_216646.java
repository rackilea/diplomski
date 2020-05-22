public class DrawCanvasCircle extends View
{
    Context context;

    public DrawCanvasCircle(Context mContext)
    {
        super(mContext);
        context = mContext;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(0xFF0000);
        paint.setAlpha(255);
        paint.setStrokeWidth(2.0f);
        paint.setStyle(Paint.Style.STROKE);
        WindowManager mWinMgr = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        int displayWidth = mWinMgr.getDefaultDisplay().getWidth();
        int displayHeight = mWinMgr.getDefaultDisplay().getHeight();
        int circleRadius = 100;
        canvas.drawCircle(displayWidth/2, displayHeight/4, circleRadius, paint);
        invalidate();
    }

}