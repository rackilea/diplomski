BufferedImage image = null;
try {
    image = ImageIO.read(getClass().getResource("/images/usFlag.png"));
} catch (IOException ex) {
    ex.printStackTrace();
}