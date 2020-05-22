public class CoordinateComparator implements Comparator<Point2D.Float> {
 public CoordinateComparator() {}

 @Override
 public int compare(Point2D.Float p1, Point2D.Float p2) {
        if (p1.getX() < p2.getX()) 
         return -1;
        if (p1.getX() > p2.getX())
         return 1;
        if (p1.getY() < p2.getY())
         return -1;
        if (p1.getY() > p2.getY())
         return 1;
        return 0;
 }
}

CoordinateComparator coordCompare = new CoordinateComparator();
TreeSet<Point2D.Float> coordSet = new TreeSet<Point2D.Float>(coordCompare);