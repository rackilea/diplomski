public static BufferedImage convert(BufferedImage src, int bufImgType) {
    BufferedImage img= new BufferedImage(src.getWidth(), src.getHeight(), bufImgType);
    Graphics2D g2d= img.createGraphics();
    g2d.drawImage(src, 0, 0, null);
    g2d.dispose();
    return img;
}