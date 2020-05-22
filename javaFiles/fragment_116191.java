// Obtain MotionEvent object
long downTime = SystemClock.uptimeMillis();
long eventTime = SystemClock.uptimeMillis() + 100;
float x = 0.0f;
float y = 0.0f;
int metaState = 0;
MotionEvent motionEvent = MotionEvent.obtain(
            downTime, 
            eventTime, 
            MotionEvent.ACTION_UP, 
            x, 
            y, 
            metaState
        );

// Dispatch touch event to the view which contains all the images
tabScrollView.dispatchTouchEvent(motionEvent);