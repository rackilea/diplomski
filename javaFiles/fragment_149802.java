int force = ...; // from 0 to 250
int radius = ...; // radius of the target (50 for example)
int centerX = ...; // X-coordinate of the center of the target
int centerY = ...; // Y-coordinate of the center of the target
double direction = Math.toRadians(Math.random() * 360); // a random angle between 0° and 360°
double x = (force * radius / 250.0d) * Math.cos(direction) + centerX; // X-coordinate of the new point
double y = (force * radius / 250.0d) * Math.sin(direction) + centerY; // Y-coordinate of the new point
Point2D point = new Point2D.Double(x,y); // Then you can plot this point on your target