iv1.setOnTouchListener(new View.OnTouchListener() {        
@Override
public boolean onTouch(View v, MotionEvent event) {
    switch(event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            // PRESSED
            iv1.setImageResource(R.drawable.button_push);
            return true; // if you want to handle the touch event
        case MotionEvent.ACTION_UP:
            // RELEASED
            iv1.setImageResource(R.drawable.button_normal);
            return true; // if you want to handle the touch event
    }
    return false;
}
});