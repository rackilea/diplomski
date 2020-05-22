public class DrawView extends View {

    Paint paintRect = new Paint();
    Paint paintClear = new Paint();
    private Point touch = new Point();

    public DrawView(Context context){
        super(context);
        paintClear.setColor(Color.BLACK);
        paintRect.setColor(Color.GREEN);
    }

    @Override
    public void onDraw(Canvas canvas){
        canvas.drawPaint(paintClear);
        canvas.drawRect(touch.x-50,touch.y-50,touch.x+50,touch.y+50,paintRect);
    }

    private void touch(int x, int y) {
        touch.set(x,y);          
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {       
        touch((int)event.getX(), (int)event.getY());
        return true;
    }

}