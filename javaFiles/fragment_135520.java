double startX = 100;
double startY = 100;
double endX   = 500;
double endY   = 500;

AffineTransform rotation = new AffineTransform();      
double angle = Math.toRadians(90);
rotation.rotate(angle, 200, 200); 

Line2D.Double line = new Line2D.Double(startX, startY, endX, endY);
PathIterator it = line.getPathIterator(rotation);
while(!it.isDone()) {
    double [] values = new double[6];
    it.currentSegment(values);
    System.out.println("["+values[0] + ", " + values[1] + "]");
    it.next();
}