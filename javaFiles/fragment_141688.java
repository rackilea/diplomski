// The gesture threshold expressed in dip
private static final float GESTURE_THRESHOLD_DIP = 16.0f;

// Convert the dips to pixels
final float scale = getContext().getResources().getDisplayMetrics().density;
mGestureThreshold = (int) (GESTURE_THRESHOLD_DIP * scale + 0.5f);

// Use mGestureThreshold as a distance in pixels