/**
 * Factory for PointF 
 * @param origin of the coordinate system (not needed)
 * @param distance this really means "radius"
 * @param angle from the x-axis in radians; positive increases in the counterclockwise direction 
 */
public static PointF getPoint(PointF origin, float distance, float angle)
{
    PointF newPoint = new PointF();
    newPoint.x = origin.x + distance*Math.cos(angle);
    newPoint.y = origin.y + distance*Math.sin(angle);
    return newPoint;
}