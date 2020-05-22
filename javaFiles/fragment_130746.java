View.OnTouchListener flTouch = new View.OnTouchListener() {

@Override
public boolean onTouch(View v, MotionEvent event) {
       // your current content of the method here
       // ...
       if (event.getAction() == MotionEvent.ACTION_DOWN) {
           callGetXY = false;
       }

       if (event.getAction() == MotionEvent.ACTION_UP) {
           callGetXY = true;
       }

    }
};