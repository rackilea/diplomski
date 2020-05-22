private boolean buttonClicked = false;

public void pushClick(View pushClick) {
    switch (pushClick.getId()) {
    case R.id.btn_push:
        buttonClicked = true;
        make(degrees);

    }
}

@Override
public boolean onTouchEvent(MotionEvent event) {
    if(buttonClicked)
    {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            startRotating();
            break;
        case MotionEvent.ACTION_UP:
            stopRotating();
            break;
        }
    } 

    return super.onTouchEvent(event);
}