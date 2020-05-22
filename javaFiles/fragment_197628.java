public class GUI extends View{

Context mcontext; 
public MyView(Context context) {
    super(context);
            mcontext=context; 
}
@Override
public boolean onTouchEvent(MotionEvent event) {
Toast.makeText(mcontext, "View clicked", 1000).show();
switch (event.getAction()) {
    case MotionEvent.ACTION_DOWN:
        // do something
        break;
    case MotionEvent.ACTION_MOVE:
        // do something
        break;
    case MotionEvent.ACTION_UP:
       //do something
        break;
}
return true;
}