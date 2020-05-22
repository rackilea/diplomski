void paintGraph(Graphics2D g, Dimension size) {
    g.setFont(g.getFont().deriveFont(fontSize));
    g.drawString(text, xPos, yPos);
    g.setFont(saveFont);
    // ...etc
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    paintGraph((Graphics2D) g, getSize());
}

void saveToFile(File f) {
    BufferedImage image = new BufferedImage(512, 512, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g = image.createGaphics();
    paintGraph(g, new Dimension(image.getWidth(), image.getHeight());
    g.dispose();

    ImageIO.write(image, "PNG", f);
}