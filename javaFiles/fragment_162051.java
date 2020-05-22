// Pointer info
PointerInfo pi = MouseInfo.getPointerInfo();
Point mp = pi.getLocation();
// The devices bounds
Rectangle bounds = getDeviceBounds(pi.getDevice());

// Create new "virtual" point based on the mouse point
virtualPoint = new Point(mp);
// Subtract the x/y position of the device
virtualPoint.x -= bounds.x;
virtualPoint.y -= bounds.y;
// Clip negative values...
if (virtualPoint.x < 0) {
    virtualPoint.x *= -1;
}
if (virtualPoint.y < 0) {
    virtualPoint.y *= -1;
}