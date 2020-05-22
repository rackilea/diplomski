public class MyJPanel extends JPanel {
  private JDialog dialog;

  public MyJPanel(Frame aFram) {
    dialog = new MyJDialog(aFrame, true);
  }
}