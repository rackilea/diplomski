View nestedScrollView = view.findViewById(R.id.nested_scroll_view);
    if (nestedScrollView != null) {
        float posX = 0.0f;
        float posY = 0.0f;
        int state = 0;

        // Prepare and perform fake action down
        long downTime = SystemClock.uptimeMillis();
        long eventTime = SystemClock.uptimeMillis() + 100;
        int eventType = MotionEvent.ACTION_DOWN;
        MotionEvent motionEvent = MotionEvent.obtain(downTime, eventTime, eventType, posX, posY, state);
        nestedScrollView.dispatchTouchEvent(motionEvent);

        // Prepare and perform fake action up
        downTime = SystemClock.uptimeMillis();
        eventTime = SystemClock.uptimeMillis() + 100;
        eventType = MotionEvent.ACTION_DOWN;
        motionEvent = MotionEvent.obtain(downTime, eventTime, eventType, posX, posY, state);
        nestedScrollView.dispatchTouchEvent(motionEvent);
    }