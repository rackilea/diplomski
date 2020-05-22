import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PointsByDistanceTest
{
    public static void main(String[] args) 
    {
        List<Point2D> points = new ArrayList<Point2D>();

        points.add(new Point2D.Double(1,1));
        points.add(new Point2D.Double(2,2));
        points.add(new Point2D.Double(3,3));
        points.add(new Point2D.Double(4,4));
        points.add(new Point2D.Double(5,5));
        points.add(new Point2D.Double(6,6));

        Point2D myPoint = new Point2D.Double(4,4);

        Collections.sort(points, createComparator(myPoint));

        double maxDistance = 2.0;
        int index = 0;
        for (Point2D p : points)
        {
            if (p.distanceSq(myPoint) > maxDistance * maxDistance)
            {
                break;
            }
            index++;
        }
        List<Point2D> result = points.subList(0, index);
        System.out.println(
            "The closest points with distance <="+maxDistance+" are "+result);
    }

    private static Comparator<Point2D> createComparator(Point2D p)
    {
        final Point2D finalP = new Point2D.Double(p.getX(), p.getY());
        return new Comparator<Point2D>()
        {
            @Override
            public int compare(Point2D p0, Point2D p1)
            {
                double ds0 = p0.distanceSq(finalP);
                double ds1 = p1.distanceSq(finalP);
                return Double.compare(ds0, ds1);
            }

        };
    }

}