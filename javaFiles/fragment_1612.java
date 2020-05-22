for (int i = 0; i < ev.getPointerCount(); i++) {
        switch (ev.getAction() & MotionEvent.ACTION_MASK) {
        case MotionEvent.ACTION_DOWN:
        case MotionEvent.ACTION_POINTER_DOWN:
            Log.d(TAG,"down "+ ev.getPointerId(i));
            break;
        case MotionEvent.ACTION_MOVE:
            Log.d(TAG,"move "+ ev.getPointerId(i));
            break;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_POINTER_UP:
            Log.d(TAG,"up "+ ev.getPointerId(i));
            break;  
        }
    }