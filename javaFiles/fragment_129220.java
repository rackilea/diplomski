public class Test extends JFrame implements KeyListener {
  JFrame f; // Remove this.

  public Test () {
    super();
    addKeyListener (this);
    setFocusable (true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500, 500);
  }
}