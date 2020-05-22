Block block = ((Block) v.getParent());

switch (event.getAction() & MotionEvent.ACTION_MASK) {
    case MotionEvent.ACTION_DOWN:
        block.requestDisallowInterceptTouchEvent(true);
        onDown(block, X, Y, MotionEvent.ACTION_DOWN);
        break;
        }