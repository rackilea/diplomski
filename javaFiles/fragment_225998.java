// this will hold the data of each path the user draws
class DrawnItem {
    int color = Color.GREEN; // default values
    Path line = new Path();
}

Paint paint;
int mCurrentColor = Color.GREEN; // start with green
ArrayList<DrawnItem> mDrawings = new ArrayList<DrawnItem>();

// in the onDraw method:
protected void onDraw(Canvas canvas) {
    final int count = mDrawings.size();
    for (int i = 0; i < count; i++) {
        final DrawnItem item = mDrawings.get(i);
        paint.setColor(item.color);
        canvas.drawPath(item.line, paint);
    }
    paint.setColor(mCurrentColor);
    canvas.drawCircle(x, y, 10, paint);
}

private DrawnItem mCurrentItem = null;

// and in the onTouch method:
public boolean onTouchEvent(MotionEvent event) {
    final int action = event.getAction();
    switch (action) {
    case MotionEvent.ACTION_DOWN:
       // the user started a new drawing so build a new DrawnItem
       mCurrentItem = new DrawnItem();
       mCurrentitem.color= mCurrentColor;  
       mDrawings.add(mCurrentItem);
       // use the item.line to setup the Path with the x and y values
       // .... 
       invalidate();
       break; 
       case MotionEvent.ACTION_MOVE:
           x = event.getX();
           y = event.getY();
           mCurrentItem.line.lineTo(x, y);
           invalidate();
       break;
    case MotionEvent.ACTION_UP:
        mCurrentItem.line.lineTo(event.getX(), event.getY());
        mCurrentItem = null;
        invalidate();
        break;
    case MotionEvent.ACTION_CANCEL:
        mCurrentItem = null; // this drawing session was canceled so this DrawnItem is now closed
        break;
    default:
        break;