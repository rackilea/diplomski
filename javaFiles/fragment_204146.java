public class MouseHandler implents MouseListener {

  private BufferedImage image;

  public MouseHandler(BufferedImage image) {
    this.image = image;
  }
  public void mouseClicked (MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    System.out.printf("You clicked at: %d,%d\n", x, y);
    System.out.printf("Color is: %d", image.getRGB(x, y));
  }
  ...
}