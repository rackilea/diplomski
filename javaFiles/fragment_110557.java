public class DrawCircles extends JPanel {
  Image im = new BufferedImage(...);
  public void drawCircle(int x, int y) {
    im.getGraphics().drawOval(x,y,50,50); //TODO: should really dispose the Graphics object after drawing the oval
    repaint();
  }

  public void paintComponent(Graphics g) {
    g.drawImage(im,0,0,null);
  }
}