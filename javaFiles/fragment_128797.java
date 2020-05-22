// a random value in [0, 2PI] for the angle in radians
float angle = rand.nextFloat()*2*Math.PI; 
// length of the line
float magnitude = 50.0f;

// start point
Point2D.Float start = new Point2D.Float(100,100);
// end point
Point2D.Float end = new Point2D.Float(start.getX() + Math.cos(angle)*magnitude, start.getY() + Math.sin(angle)*magnitude);