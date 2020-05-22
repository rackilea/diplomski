public class Cursor extends View {    
    public Cursor(Context context) {
        super(context);
        startTime = System.currentTimeMills();
    }

    @Override
    protected void onDraw(Canvas canvas){
        long delta = System.currentTimeMills() - startTime;
        // ... calculate x and y using delta
        canvas.drawCircle(x, y, radius, paint);
        invalidate();
    }
}