@Override
public boolean onTouch(View v, MotionEvent event) {
   //Get id of touched View
   getViewByID = v.getId();
   return gestureDetector.onTouchEvent(event);
}