int panDist = 50;

BufferedImage newImg = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
for (int x = panDist; x < img.getWidth(); ++x) {
    for (int y = 0; y < img.getHeight(); ++y) {
        newImg.setRGB(x - panDist, y, img.getRGB(x, y));
    }
}