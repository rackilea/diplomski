float x = touchevent.getX();
float y = touchevent.getY();

// Transform relative to arc centers
x -= circle1.x;
y -= circle1.y;

double dist = Math.sqrt(x*x + y*y);
double angle = Math.atan2(y,x) * 180 / Math.PI;

// Given an arc segment defined by circle1, circle2, angle1, angle2:
boolean touch = dist > circle1.radius && dist < circle2.radius &&
                angle > angle1 && angle < angle2;