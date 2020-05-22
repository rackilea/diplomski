public class HoofdMenu extends JPanel {
  // ... member vars

  public HoofdMenu() {
    this.addMouseListener(new MouseInput());
  }

  @Override
  public void paintComponent(Graphics g) {
    // ... don't add listener in here
  }