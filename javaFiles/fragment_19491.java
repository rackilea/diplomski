private Rect rect;    // Variable rect to hold the bounds of the view

public boolean onTouch(View v, MotionEvent event) {
    switch (event.getAction()) {
        case MotionEvent.ACTION_UP:
            if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                // User moved outside bounds
            }
            break;
        case MotionEvent.ACTION_DOWN:
            rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
            break;
    }
    return false;
}