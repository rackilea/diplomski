// Record the angle at initial touch for use in dragging.
dialAngleAtTouch = dialAngle;
// Find angle from x-axis made by initial touch coordinate.
// y-coordinate might need to be negated due to y=0 -> screen top. 
// This will be obvious during testing.
a0 = Math.atan2(y0 - yDialCenter, x0 - xDialCenter);