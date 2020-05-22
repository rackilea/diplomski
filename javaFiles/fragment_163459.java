// (x, y) in screen coordinates
private static GestureDescription createClick(float x, float y) {
    // for a single tap a duration of 1 ms is enough
    final int DURATION = 1;

    Path clickPath = new Path();
    clickPath.moveTo(x, y);
    GestureDescription.StrokeDescription clickStroke =
            new GestureDescription.StrokeDescription(clickPath, 0, DURATION);
    GestureDescription.Builder clickBuilder = new GestureDescription.Builder();
    clickBuilder.addStroke(clickStroke);
    return clickBuilder.build();
}

// callback invoked either when the gesture has been completed or cancelled
callback = new AccessibilityService.GestureResultCallback() {
    @Override
    public void onCompleted(GestureDescription gestureDescription) {
        super.onCompleted(gestureDescription);
        Log.d(TAG, "gesture completed");
    }

    @Override
    public void onCancelled(GestureDescription gestureDescription) {
        super.onCancelled(gestureDescription);
        Log.d(TAG, "gesture cancelled");
    }
};

// accessibilityService: contains a reference to an accessibility service
// callback: can be null if you don't care about gesture termination
boolean result = accessibilityService.dispatchGesture(createClick(x, y), callback, null);
Log.d(TAG, "Gesture dispatched? " + result);