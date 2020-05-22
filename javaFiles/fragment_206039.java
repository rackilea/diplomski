Point p;
Center center;

Point relativePoint = p - center;

// For 90deg CW: -y, x
// For 90deg CC: y, -x
Point rotatedPoint = new Point(-1 * relativePoint.Y, relativePoint.X); // 90deg CW
Point finalPoint = rotatedPoint + center;