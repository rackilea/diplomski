/**
 * Return the Shape that has the largest surface area.  If two shapes
 * have the same area, the first in the list is returned.
 * If empty array is passed, null is returned.
 */
public static Shape maxSurfaceArea(Shape[] shapeList)
{
  Shape max;
  for (Shape shape : shapeList) {
    if (max == null) {
      // first time through
      max = shape;
    } else if (shape.computeArea() > max.computeArea()) {
      max = shape;
      /* If really worried about performance you could store the result of
       * max.computeArea() in a local var and use that in the next loop.
       */
    }
  }
  return max;
}