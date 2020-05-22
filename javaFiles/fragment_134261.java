tv.setOnTouchListener(new CustomTouchListener());

public class CustomTouchListener implements View.OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch(motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN: // Action you you want on finger down.
                Toast.makeText(this,"onTouch",Toast.LENGTH_LONG).show();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP: // Action you you want on finger up
                break;
        }
        return false;
    }
}