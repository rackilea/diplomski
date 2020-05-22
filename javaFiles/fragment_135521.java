double startX = 100;
double startY = 100;
double endX   = 500;
double endY   = 500;

AffineTransform rotation = new AffineTransform();      
double angle = Math.toRadians(90);
rotation.rotate(angle, 200, 200); 

Path2D path = new Path2D.Double();
path.moveTo(startX, startY);
path.lineTo(endX, endY);

path.transform(rotation);

double [] values = new double[6];
for(PathIterator it = path.getPathIterator(null); !it.isDone();) {
    it.currentSegment(values);
    System.out.println("["+values[0] + ", " + values[1] + "]");
    it.next();
}