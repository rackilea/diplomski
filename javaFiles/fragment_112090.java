double xDirection = currentX - nextX;
double yDirection = currentY - nextY;
double magnitude = Math.sqrt(xDirection*xDirection + yDirection*yDirection);

double xUnit = xDirection/magnitude;
double yUnit = yDirection/magnitude;