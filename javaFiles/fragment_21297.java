public class DrawArea extends JPanel {
  // we've no idea if this is the correct path just yet.
  private static final String IMG_PATH = "/exit.png";

  public DrawArea() { // better have it throw the proper exceptions!
    setPreferredSize( new Dimension( 570, 570 ) ); // not sure about this either
    //  setVisible(true); // no need for this
    img = ImageIO.read(getClass().getResourceAsStream(IMG_PATH));
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (img != null) {
      g.drawImage(img, 0, 0, this);
    }
  }