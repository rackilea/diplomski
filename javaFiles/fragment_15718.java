import java.awt.Point;

public class Util{

  /**
   * Returns closest point on segment to point
   * @param ss - segment start point
   * @param se - segment end point
   * @param p - point to found closest point on segment
   * @return closest point on segment to p
   */
  public static Point getClosestPointOnSegment(Point ss, Point se, Point p)
  {
    return getClosestPointOnSegment(ss.x, ss.y, se.x, se.y, p.x, p.y);
  }

  /**
   * Returns closest point on segment to point
   * @param sx1 - segment x coord 1
   * @param sy1 - segment y coord 1
   * @param sx2 - segment x coord 2
   * @param sy2 - segment y coord 2
   * @param px - point x coord
   * @param py - point y coord
   * @return closets point on segment to point
   */
  public static Point getClosestPointOnSegment(int sx1, int sy1, int sx2, int sy2, int px, int py)
  {
    double xDelta = sx2 - sx1;
    double yDelta = sy2 - sy1;

    if ((xDelta == 0) && (yDelta == 0))
    {
      throw new IllegalArgumentException("Segment start equals segment end");
    }

    double u = ((px - sx1) * xDelta + (py - sy1) * yDelta) / (xDelta * xDelta + yDelta * yDelta);

    final Point closestPoint;
    if (u < 0)
    {
      closestPoint = new Point(sx1, sy1);
    }
    else if (u > 1)
    {
      closestPoint = new Point(sx2, sy2);
    }
    else
    {
      closestPoint = new Point((int) Math.round(sx1 + u * xDelta), (int) Math.round(sy1 + u * yDelta));
    }
    return closestPoint;
  }
}