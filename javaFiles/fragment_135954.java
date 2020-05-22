public static BufferedImage rotate(BufferedImage srcImage, double angle)
{
    double sin = Math.abs(Math.sin(Math.toRadians(angle))), cos = Math.abs(Math.cos(Math.toRadians(angle)));

    int originWidth = srcImage.getWidth(), originHeight = srcImage.getHeight();

    int newWidth = (int) Math.floor(originWidth * cos + originHeight * sin), newHeight = (int) Math.floor(originHeight * cos + originWidth * sin);

    BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = newImage.createGraphics();

    g.translate((newWidth - originWidth) / 2, (newHeight - originHeight) / 2);
    g.rotate(Math.toRadians(angle), originWidth / 2, originHeight / 2);
    g.drawImage(srcImage, 0, 0, null);
    g.dispose();

    return newImage;
}