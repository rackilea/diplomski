// Find new angle to x-axis. Same comment as above on y coord.
a = Math.atan2(y - yDialCenter, x - xDialCenter);
// New dial angle is offset from the one at initial touch.
dialAngle = dialAngleAtTouch + (a - a0); 
// normalize angles to the interval [0..2pi)
while (dialAngle < 0) dialAngle += 2 * Math.PI;
while (dialAngle >= 2 * Math.PI) dialAngle -= 2 * Math.PI;

// Set the matrix for every frame drawn. Matrix API has a call
// for rotation about a point. Use it!
matrix.setRotate((float)dialAngle * (180 / 3.1415926f), xDialCenter, yDialCenter);

// Invalidate the view now so it's redrawn in with the new matrix value.