BufferedImage image = new BufferedImage(imgIn.getWidth(), imgIn.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

Grphics2D g = image.createGraphics();

try {
    g.drawImage(imgIn, 0, 0, null);
}
finally {
    g.dispose();
}