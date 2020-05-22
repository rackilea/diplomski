public static void main(String[] args) throws IOException {
    BufferedImage image = ImageIO.read(new File("c:/images.jpg"));
    BufferedImage image2 = ImageIO.read(new File("c:/images2.png"));

    int w = image2.getWidth();
    int h = image2.getHeight();

    Graphics2D graphics = image.createGraphics();
    graphics.drawImage(image2, 0, 0, w, h, null);
    graphics.dispose();
    // here goes the code to show it on JFrame
}