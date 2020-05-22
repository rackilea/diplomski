import java.awt.geom.Point2D; //Note: only import Point2D, not Point2D.Double

public class Test {

    public static void main(String[] args) {
        Point2D.Double point = new Point2D.Double(1.5, 2.5);
        double x = point.getX(); //1.5
        double y = point.getY(); //2.5
        Double xx = point.getX(); //1.5
        Double yy = point.getY(); //2.5
    }
}