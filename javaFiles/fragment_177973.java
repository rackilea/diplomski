public static void main(String[] v) {

class StartImagePanel extends JPanel {
  private Image image;
  public StartImagePanel(Image image) {
      this.image = image;
  }
  @Override
  protected void paintComponent(Graphics g) {
    g.drawImage(image, 0, 0, null);
  }
}

class GameWindow extends JFrame{
  public GameWindow() {
    BufferedImage RollrackLogo;
    RollrackLogo = new BufferedImage(400,200,BufferedImage.TYPE_INT_RGB);
    final JButton JBRandom = new JButton();
    final JLabel JLWelcome = new JLabel();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    StartImagePanel panel = new StartImagePanel(RollrackLogo);
    setContentPane(panel);
    setExtendedState(MAXIMIZED_BOTH);
    setVisible(true);
    JLWelcome.setText("Welcome to Rollrack");
    panel.add(JLWelcome);
    JLWelcome.setVisible(true);
    JBRandom.setText("Random");
    panel.add(JBRandom);
    JBRandom.setVisible(true);
  }
}

GameWindow window = new GameWindow();
window.pack();
window.setVisible(true);
}