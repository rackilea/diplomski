/**
 * Resizes the image {@code tgtImage} by setting one of its dimensions
 * (width or height, specified via {@code tgtDimension}) to {@code tgtSize}
 * and dynamically calculating the other one in order to preserve the aspect
 * ratio.
 *
 * @param tgtImage The image to be resized.
 * @param tgtDimension The selected dimension: {@code ImageUtil.WIDTH} or
 * {@code ImageUtil.WIDTH}.
 * @param tgtSize The new value for the selected dimension.
 *
 * @return The resized image.
 */
public static BufferedImage resize(BufferedImage tgtImage, short tgtDimension, int tgtSize) {

    int newWidth = 0, newHeight = 0;

    if (HEIGHT == tgtDimension) {
        newHeight = tgtSize;
        newWidth = (tgtImage.getWidth() * tgtSize) / tgtImage.getHeight();
    } else {
        newHeight = (tgtImage.getHeight() * tgtSize) / tgtImage.getWidth();
        newWidth = tgtSize;
    }

    Image tmp = tgtImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    BufferedImage outImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGemoticon;

    Graphics2D g2d = outImage.createGraphics();
    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();

    return outImage;
}

/**
 * Rotates the image {@code tgtImage} by {@code tgtAngle} degrees clockwise.
 *
 * @param tgtImage The image to be rotated.
 * @param tgtAngle The rotation angle (expressed in degrees).
 *
 * @return The resized image.
 */
public static BufferedImage rotate(BufferedImage tgtImage, double tgtAngle) {

    int w = tgtImage.getWidth();
    int h = tgtImage.getHeight();

    AffineTransform t = new AffineTransform();
    t.setToRotation(Math.toRadians(tgtAngle), w / 2d, h / 2d);

    Point[] points = {
        new Point(0, 0),
        new Point(w, 0),
        new Point(w, h),
        new Point(0, h)
    };

    // Transform to destination rectangle.
    t.transform(points, 0, points, 0, 4);

    // Get destination rectangle bounding box
    Point min = new Point(points[0]);
    Point max = new Point(points[0]);
    for (int i = 1, n = points.length; i < n; i++) {
        Point p = points[ i ];
        double pX = p.getX(), pY = p.getY();

        // Update min/max x
        if (pX < min.getX()) {
            min.setLocation(pX, min.getY());
        }
        if (pX > max.getX()) {
            max.setLocation(pX, max.getY());
        }

        // Update min/max y
        if (pY < min.getY()) {
            min.setLocation(min.getX(), pY);
        }
        if (pY > max.getY()) {
            max.setLocation(max.getX(), pY);
        }
    }

    // Determine new width, height
    w = (int) (max.getX() - min.getX());
    h = (int) (max.getY() - min.getY());

    // Determine required translation
    double tx = min.getX();
    double ty = min.getY();

    // Append required translation
    AffineTransform translation = new AffineTransform();
    translation.translate(-tx, -ty);
    t.preConcatenate(translation);

    AffineTransformOp op = new AffineTransformOp(t, null);
    BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGemoticon;
    op.filter(tgtImage, outImage);

    return outImage;
}