public void newFrameRecieved(int[] rgbBuffer, Dimension max)
{
    before = new BufferedImage(max.width, max.height, BufferedImage.TYPE_INT_ARGB);
    before.setRGB(0, 0, max.width, max.height, rgbBuffer, 0, max.width);
    after = new BufferedImage(this.getWidth(), this.getHeight(), this.image.getType());
    at = new AffineTransform();
    scalingFactorX = (double)after.getWidth()/ (double)before.getWidth();
    scalingFactorY = (double)after.getHeight()/ (double)before.getHeight();
    at.scale(scalingFactorX, scalingFactorY);
    scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
    this.image = scaleOp.filter(before, after);

    repaint();
}