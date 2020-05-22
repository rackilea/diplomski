@Override
public boolean onTouchEvent(MotionEvent event) {

    if (event.getAction() == MotionEvent.ACTION_DOWN) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        if(isInsideCircle(x, y) ==  true) {
            //Do your things here
            if(redColor == lastColor){
                Intent i = new Intent(v.getContext(), YouFailed.class);
                this.getContext().startActivity(i);
            } else {
                addPoints++;
            }
        } else {
             //Handle case not inside the circle
        }
    }

    return true;
}