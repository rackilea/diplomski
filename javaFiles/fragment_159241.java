public static BufferedImage toBufferedImage(Image image) {
    if (image instanceof BufferedImage) {
        // Return image unchanged if it is already a BufferedImage.
        return (BufferedImage) image;
    }

    // Ensure image is loaded.
    image = new ImageIcon(image).getImage();

    BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),  BufferedImage.TYPE_INT_ARGB);
    Graphics g = bufferedImage.createGraphics();
    g.drawImage(image, 0, 0, null);
    g.dispose();

    return bufferedImage;
}