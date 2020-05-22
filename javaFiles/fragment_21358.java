@Override
public boolean onTouchEvent(MotionEvent event) {

    if (isUnwantedTouch(event))
        return false;

    switch (event.getAction()) {
    // ... same as before
}