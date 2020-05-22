button.setOnTouchListener(new OnTouchListener() {
@Override
public boolean onTouch(View v, MotionEvent event) {
    if(event.getAction() == MotionEvent.ACTION_UP){

        // Do what you want
        return true;
    }
    return false;
}
});