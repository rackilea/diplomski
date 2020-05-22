/**
 * My Pixel level test - 2D
 *
 * @param rect the rectangle representing the intersection of the bounding
 * boxes
 * @param index1 the index at which the first objects texture is stored
 * @param index2 the index at which the second objects texture is stored
 * @param p1 the position of object 1
 * @param p2 the position of object 2
 * @return true if there is a collision at a pixel level false if not
 */
//public static boolean isPixelCollision(Rectangle2D rect, Point2D.Float p1, Bitmask bm1, Point2D.Float p2, Bitmask bm2)
public static boolean isPixelCollision(Rectangle2D rect, Point2D.Float p1, int index1, Point2D.Float p2, int index2)
{
    int height = (int) rect.getHeight();
    int width = (int) rect.getWidth();

    byte mask1 = 0;
    byte mask2 = 0;

    //drop both objects to the origin and drop a rectangle of intersection for each along with them
    //this allows for us to have the co-ords of the rect on intersection within them at number that are inbounds.
    Point2D.Float origP1 = new Point2D.Float((float) Math.abs(rect.getX() - p1.x), (float) Math.abs(rect.getY() - p1.y));//rect for object one
    Point2D.Float origP2 = new Point2D.Float((float) Math.abs(rect.getX() - p2.x), (float) Math.abs(rect.getY() - p2.y));//rect for object two

    //to avoid casting with every iteration
    int start1y = (int) origP1.y;
    int start1x = (int) origP1.x;
    int start2y = (int) origP2.y;
    int start2x = (int) origP2.x;

    //we need to loop within the rect of intersection
    //goind bottom up and left to right
    for (int i = height - 1; i > 0; i--)
    {
        for (int j = 0; j < width; j++)
        {
            mask1 = bitmaskArr[index1].bitmask[start1y + i][start1x + j];
            mask2 = bitmaskArr[index2].bitmask[start2y + i][start2x + j];
            if ((mask1 & mask2) > 0)
            {
                return true;
            }
        }

    }
    //no collsion was found
    return false;
}