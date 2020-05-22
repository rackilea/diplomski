public class HomePanel extends JPanel implements KeyListener {
  ...
  private KeyPressStats stats;

  public HomePanel(KeyPressStats stats) {
    this.stats = stats;
    countUpButton = new JButton("Left");
    countUpButton.setBounds(195, 121, 75, 29);
    ...
  }

  @Override
  public void keyPressed(KeyEvent e) {    
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      stats.incrementLeft();
      counterLabel.setText("" + stats.getLeftCount());
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      stats.incrementRight();
      counterLabel2.setText("" + stats.getRightCount());
    }
  }


public class StatsPanel extends JPanel {
...
  public StatsPanel(KeyPressStats stats) {
    ...
    textField_2 = new JTextField(""+stats.getLeftCount());
    textField_2.setBounds(160, 33, 134, 28);
    ...
    textField_3 = new JTextField(""+stats.getRightCount());
    textField_3.setBounds(160, 61, 134, 28);
    ...
  }
}