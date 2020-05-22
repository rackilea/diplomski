ColorModel cm = src.getColorModel();
if (interpolationType != TYPE_NEAREST_NEIGHBOR &&
    (cm instanceof IndexColorModel ||
     cm.getTransparency() == Transparency.OPAQUE)
{
    image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
}
else {
    image = new BufferedImage(cm,
              src.getRaster().createCompatibleWritableRaster(w,h),
              cm.isAlphaPremultiplied(), null);
}