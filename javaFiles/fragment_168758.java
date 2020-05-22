import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReactionPanel extends JPanel {
  private JLabel label;

  public ReactionPanel() {
    label = new JLabel("PING");
    this.add(label);
  }

  public void react() {
    if(label.getText().equals("PING")) {
      label.setText("PONG");
    } else {
      label.setText("PING");
    }
  }
}