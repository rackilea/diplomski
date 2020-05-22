double r  = (...);  // Radius of circle
double cX = (...);  // x-coordinate of center of rotation
double cY = (...);  // y-coordinate of center of rotation

double omega = (...);  // Angular velocity, like 1
double t = (...);  // Time step, like 0.00, 0.01, 0.02, 0.03, etc.

newPos.x = cX + r * Math.cos(t * omega);
newPos.y = cY + r * Math.sin(t * omega);