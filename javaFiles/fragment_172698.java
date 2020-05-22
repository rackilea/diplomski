@Override
   public boolean onTouchEvent(MotionEvent event) {
    // Get the pointer ID
    Camera.Parameters params = mCamera.getParameters();
    int action = event.getAction();


    if (event.getPointerCount() > 1) {
        // handle multi-touch events
        if (action == MotionEvent.ACTION_POINTER_DOWN) {
            mDist = getFingerSpacing(event);
        } else if (action == MotionEvent.ACTION_MOVE && params.isZoomSupported()) {
            mCamera.cancelAutoFocus();
            handleZoom(event, params);
        }
    } else {
        // handle single touch events
        if (action == MotionEvent.ACTION_UP) {
            handleFocus(event, params);
        }
    }
    return true;
}

private void handleZoom(MotionEvent event, Camera.Parameters params) {
    int maxZoom = params.getMaxZoom();
    int zoom = params.getZoom();
    float newDist = getFingerSpacing(event);
    if (newDist > mDist) {
        //zoom in
        if (zoom < maxZoom)
            zoom++;
    } else if (newDist < mDist) {
        //zoom out
        if (zoom > 0)
            zoom--;
    }
    mDist = newDist;
    params.setZoom(zoom);
    mCamera.setParameters(params);
}

public void handleFocus(MotionEvent event, Camera.Parameters params) {
    int pointerId = event.getPointerId(0);
    int pointerIndex = event.findPointerIndex(pointerId);
    // Get the pointer's current position
    float x = event.getX(pointerIndex);
    float y = event.getY(pointerIndex);

    List<String> supportedFocusModes = params.getSupportedFocusModes();
    if (supportedFocusModes != null && supportedFocusModes.contains(Camera.Parameters.FOCUS_MODE_AUTO)) {
        mCamera.autoFocus(new Camera.AutoFocusCallback() {
            @Override
            public void onAutoFocus(boolean b, Camera camera) {
                // currently set to auto-focus on single touch
            }
        });
    }
}

/** Determine the space between the first two fingers */
private float getFingerSpacing(MotionEvent event) {
    // ...
    float x = event.getX(0) - event.getX(1);
    float y = event.getY(0) - event.getY(1);
    return FloatMath.sqrt(x * x + y * y);
}