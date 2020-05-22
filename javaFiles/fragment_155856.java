import java.awt.Polygon;

public class JavaTest {

  public static void main(final String[] args) {

    final Polygon polygon = new Polygon();
    polygon.addPoint(-10, -10);
    polygon.addPoint(-10, 10);
    polygon.addPoint(10, 10);
    polygon.addPoint(10, -10);

    System.out.println(polygon.contains(0, 0));

  }

}