import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionPanel extends JPanel implements ActionListener {
  private ReactionPanel rp;
  private JButton button;

  public ActionPanel(ReactionPanel rp) {
    this.rp = rp;
    button = new JButton("Click");
    button.addActionListener(this);
    this.add(button);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(button)) {
      rp.react();
    }
  }
}