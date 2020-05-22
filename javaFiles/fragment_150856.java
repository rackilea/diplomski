public class PointTransform implements Transform<Point> {

  public Point read(String value) {
     return fromString(value);
  }

  public String write(Point value)  {
     return toString(value);
  }

  // etc ...
}