@Override
public boolean onOptionsItemSelected(MenuItem item) {
    boolean result = false;
    int id = item.getItemId();
    if (id == R.id.action_settings) {

        //Returning false here allows the touch event to bubble up.
        result = false;
    } else {
        result = super.onOptionsItemSelected(item);
    }
    return result;
}


@Override
public boolean dispatchGenericMotionEvent(MotionEvent ev) {
    Log.d(TAG, "dispatchGenericMotionEvent");
    // do some other stuff
    return super.dispatchGenericMotionEvent(ev);
}
@Override
public boolean dispatchTouchEvent(MotionEvent ev) {
    Log.d(TAG, "dispatchTouchEvent");
    // do stuff here....
    return super.dispatchTouchEvent(ev);
}