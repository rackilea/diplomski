int panDist = 50;

BufferedImage subImg = img.getSubimage(panDist, 0, img.getWidth() - panDist, img.getHeight());

BufferedImage newImg = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
for (int x = 0; x < subImg.getWidth(); ++x) {
    for (int y = 0; y < subImg.getHeight(); ++y) {
        newImg.setRGB(x, y, subImg.getRGB(x, y));
    }
}