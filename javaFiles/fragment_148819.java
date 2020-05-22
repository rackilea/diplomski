package spreadsheet;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

    public class RangeTest {

    @Test
    public void testSomePoints() throws Exception {
        Range range = new Range(new Point(1, 1), new Point(5, 5));
        ArrayList<Point> points = range.getPoints();
        for (Point point : points) {
            System.out.println(point);
        }
    }
}