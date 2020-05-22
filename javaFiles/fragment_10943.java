public static BufferedImage scale(BufferedImage sbi, 
    int imageType,   /* type of image */
    int destWidth,   /* result image width */
    int destHeight,  /* result image height */
    double widthFactor, /* scale factor for width */ 
    double heightFactor /* scale factor for height */ ) 
{
    BufferedImage dbi = null;
    if(sbi != null) {
        dbi = new BufferedImage(destWidth, destHeight, imageType);
        Graphics2D g = dbi.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(widthFactor, heightFactor);
        g.drawRenderedImage(sbi, at);
    }
    return dbi;
}