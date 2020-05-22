package stackoverflow;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Demonstration of an implementation to rotate rectangles.
 * @author Franz D.
 */
public class ImageRotate
{
    /**
     * Rotates a rectangle with offset (0,0).
     * @param originalWidth original rectangle width
     * @param originalHeight original rectangle height
     * @param angleRadians rotation angle in radians
     * @param rotatedCorners output buffer for the four rotated corners
     * @return the bounding box of the rotated rectangle
     * @throws NullPointerException if {@code rotatedCorners == null}.
     * @throws ArrayIndexOutOfBoundsException if {@code rotatedCorners.length &lt; 4}.
     */
    public static Rectangle2D rotateRectangle(int originalWidth, int originalHeight,
            double angleRadians,
            Point2D[] rotatedCorners) {
        // create original corner points
        Point2D a0 = new Point2D.Double(0, 0);
        Point2D b0 = new Point2D.Double(originalWidth, 0);
        Point2D c0 = new Point2D.Double(0, originalHeight);
        Point2D d0 = new Point2D.Double(originalWidth, originalHeight);
        Point2D[] originalCorners = { a0, b0, c0, d0 };

        // create affine rotation transform
        AffineTransform transform = AffineTransform.getRotateInstance(angleRadians);

        // transform original corners to rotated corners
        transform.transform(originalCorners, 0, rotatedCorners, 0, originalCorners.length);

        // determine rotated width and height as difference between maximum and
        // minimum rotated coordinates
        double minRotatedX = Double.POSITIVE_INFINITY;
        double maxRotatedX = Double.NEGATIVE_INFINITY;
        double minRotatedY = Double.POSITIVE_INFINITY;
        double maxRotatedY = Double.NEGATIVE_INFINITY;

        for (Point2D rotatedCorner: rotatedCorners) {
            minRotatedX = Math.min(minRotatedX, rotatedCorner.getX());
            maxRotatedX = Math.max(maxRotatedX, rotatedCorner.getX());
            minRotatedY = Math.min(minRotatedY, rotatedCorner.getY());
            maxRotatedY = Math.max(maxRotatedY, rotatedCorner.getY());
        }

        // the bounding box is the rectangle with minimum rotated X and Y as offset
        double rotatedWidth = maxRotatedX - minRotatedX;
        double rotatedHeight = maxRotatedY - minRotatedY;

        Rectangle2D rotatedBounds = new Rectangle2D.Double(
                minRotatedX, minRotatedY,
                rotatedWidth, rotatedHeight);

        return rotatedBounds;
    }

    /**
     * Simple test for {@link #rotateRectangle(int, int, double, java.awt.geom.Point2D[])}.
     * @param args ignored
     */
    public static void main(String[] args) {
        // setup original width
        int originalWidth = 500;
        int originalHeight = 400;

        // create buffer for rotated corners
        Point2D[] rotatedCorners = new Point2D[4];

        // rotate rectangle from 0° to 360° in 30° steps
        for (int angleDegrees = 0; angleDegrees < 360; angleDegrees += 30) {
            // convert angle to radians
            double angleRadians = Math.toRadians(angleDegrees);

            // rotate rectangle
            Rectangle2D rotatedBounds = rotateRectangle(
                    originalWidth, originalHeight,
                    angleRadians,
                    rotatedCorners);

            // dump results
            System.out.println("--- Rotate " + originalWidth + "x" + originalHeight + " by " + angleDegrees + "° ---");
            System.out.println("Bounds: " + rotatedBounds);
            for (Point2D rotatedCorner: rotatedCorners) {
                System.out.println("Corner " + rotatedCorner);
            }
        }
    }
}