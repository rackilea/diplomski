/**
 * Transforms the image efficiently without losing image quality.
 * Scales the image to a width of (600 * scale) pixels, rotates the image,
 * and translates (moves) the image to recenter it if rotated 90 or 270 degrees.
 */
protected BufferedImage transformImage(BufferedImage image)
{
    int scaledWidth = (int)(scale * image.getWidth());
    int scaledHeight = (int)(scale * image.getHeight());

    // Methods AffineTransform.rotate(), AffineTransform.scale() and AffineTransform.translate()
    // transform AffineTransform's transformation matrix to multiply with the buffered image.
    // Therefore those methods are called in a counterintuitive sequence.
    AffineTransform transform;
    if (rotation % 180 == 0)
    {
        // First scale and second rotate image
        transform = AffineTransform.getRotateInstance(Math.toRadians(rotation), scaledWidth/2, scaledHeight/2);
        transform.scale(scale, scale);
    }
    else
    {
        // First scale, second rotate, and third translate image
        transform = AffineTransform.getTranslateInstance((scaledHeight-scaledWidth)/2, (scaledWidth-scaledHeight)/2);
        transform.rotate(Math.toRadians(rotation), scaledWidth/2, scaledHeight/2);
        transform.scale(scale, scale);
    }
    AffineTransformOp operation = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);
    BufferedImage transformedImage = operation.createCompatibleDestImage(image, image.getColorModel());
    return operation.filter(image, transformedImage);
}