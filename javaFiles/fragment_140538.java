/**
 * Transformation matrix used to transform the image
 */
private Matrix transformationM;

/**
 * Matrix that is used in calculations (inverse of tranformation matrix)
 */
private Matrix tmpM;

/**
 * Checks whether a point is on the transformed image
 */
public boolean pointIsOnImage(float x, float y) {
    // Float array that will hold the mapped point (see 'mapPoints' below)
    float[] p1 = {0, 0};

    // Float array that holds the touch position
    final float[] p2 = {x, y};

    // Reset temporary matrix
    tmpM.reset();

    // Get the inverse matrix of the current transformation matrix and store it in the temporary matrix
    transformationM.invert(tmpM);

    // Map the touch position on the inverse matrix
    tmpM.mapPoints(p1, 0, p2, 0, 1);

    // Check if touch position is in the drawable bounds
    return getDrawable().getBounds().contains((int) p1[0], (int) p1[1]);
}