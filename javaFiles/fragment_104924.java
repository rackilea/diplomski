/**
 * scale image
 * 
 * @param sbi image to scale
 * @param imageType type of image
 * @param dWidth width of destination image
 * @param dHeight height of destination image
 * @param fWidth x-factor for transformation / scaling
 * @param fHeight y-factor for transformation / scaling
 * @return scaled image
 */
public static BufferedImage scale(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
    BufferedImage dbi = null;
    if(sbi != null) {
        dbi = new BufferedImage(dWidth, dHeight, imageType);
        Graphics2D g = dbi.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
        g.drawRenderedImage(sbi, at);
    }
    return dbi;
}