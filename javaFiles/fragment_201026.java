private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

public void paint(Graphics g) {
    super.paint(g);

    Graphics imageGraphics = image.getGraphics();
    imageGraphics.setColor(Color.red);
    imageGraphics.fillOval(mouseLocX,mouseLocY,30,30);

    g.drawImage(image, 0, 0, null);
}