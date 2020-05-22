public class NewClass2 implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        if (p1.getY() < p2.getY()) return -1;
        if (p1.getY() > p2.getY()) return 1;
        return 0;
    }    
}