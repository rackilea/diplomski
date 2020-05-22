BufferedImage image = ImageIO.read(/* ... */);

GraphicsConfiguration config = getGraphicsConfiguration();
if (config == null) {
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment;
    config = env.getDefaultScreenDevice().getDefaultConfiguration();
}

BufferedImage compatibleImage = config.createCompatibleImage(
    image.getWidth(), image.getHeight(), image.getTransparency());

Graphics2D g = compatibleImage.createGraphics();
g.drawImage(image, 0, 0, null);
g.dispose();

image = compatibleImage;