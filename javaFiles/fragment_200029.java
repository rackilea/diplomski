Container pane = frame.getContentPane();
BufferedImage img = new BufferedImage(pane.getWidth(), pane.getHeight(), BufferedImage.TYPE_INT_RGB);
Graphics2D g2d = img.createGraphics();
pane.printAll(g2d);
g2d.dispose();
try {
    ImageIO.write(img, "png", new File("save.png"));
} catch (IOException ex) {
    ex.printStackTrace();
}