BufferedImage toImage(byte[] data, int w, int h)
{
    if (data.length == 0)
        return null;

    DataBuffer buffer = new DataBufferByte(data, w * h);

    int pixelStride = 3; //assuming r, g, b, skip, r, g, b, skip...
    int scanlineStride = 3 * w; //no extra padding   
    int[] bandOffsets = { 0, 1, 2 }; //r, g, b
    WritableRaster raster = Raster.createInterleavedRaster(buffer, w, h, scanlineStride, pixelStride, bandOffsets,
            null);

    ColorSpace colorSpace = ColorSpace.getInstance(ColorSpace.CS_sRGB);
    boolean hasAlpha = false;
    boolean isAlphaPremultiplied = true;
    int transparency = Transparency.TRANSLUCENT;
    int transferType = DataBuffer.TYPE_BYTE;
    ColorModel colorModel = new ComponentColorModel(colorSpace, hasAlpha, isAlphaPremultiplied, transparency,
            transferType);

    BufferedImage image = new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);

    AffineTransform flip;
    AffineTransformOp op;
    flip = AffineTransform.getScaleInstance(1, -1);
    flip.translate(0, -image.getHeight());
    op = new AffineTransformOp(flip, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
    image = op.filter(image, null);

    return image;
}