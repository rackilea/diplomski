import java.util.ArrayList;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

public class GeoTest {

  public static void main(final String[] args) {

    final GeometryFactory gf = new GeometryFactory();

    final ArrayList<Coordinate> points = new ArrayList<Coordinate>();
    points.add(new Coordinate(-10, -10));
    points.add(new Coordinate(-10, 10));
    points.add(new Coordinate(10, 10));
    points.add(new Coordinate(10, -10));
    points.add(new Coordinate(-10, -10));
    final Polygon polygon = gf.createPolygon(new LinearRing(new CoordinateArraySequence(points
        .toArray(new Coordinate[points.size()])), gf), null);

    final Coordinate coord = new Coordinate(0, 0);
    final Point point = gf.createPoint(coord);

    System.out.println(point.within(polygon));

  }

}