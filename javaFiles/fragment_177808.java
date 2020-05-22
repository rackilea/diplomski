import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainClass {

 MainClass() {
    JFrame jfrm = new JFrame("JTable Demo");
    jfrm.setLayout(new FlowLayout());
    jfrm.setSize(460, 180);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JCheckBox check = null;
    // Get the Panel from the subclass;
    JPanel panel = new CheckBox().getCheckBoxPanel();

    // From the compoenents present in the panel get the CheckBox compoenent.
    for(int i = 0; i < panel.getComponentCount(); i++) {
       if(panel.getComponent(i) instanceof JCheckBox) {
        check = (JCheckBox) panel.getComponent(i);
        }
    }

    JButton button = new JButton("Click");

    // Pass the CheckBox Compoenent to the ActionListener.
button.addActionListener(new PerformAction(check));

    jfrm.add(button);
    jfrm.add(panel);
    jfrm.setVisible(true);
 }

  public static void main(String args[]) {
  EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
          new MainClass();
      }
  });
 }
}

class PerformAction implements ActionListener {

JCheckBox check = null;
public PerformAction(JCheckBox checkBox) {
    check = checkBox;
}
@Override
public void actionPerformed(ActionEvent e) {
    boolean checkStatus = check.isSelected();
    if(checkStatus == true) {
        check.setEnabled(false);
        check.setSelected(false);
    } else {
        check.setEnabled(true);
        check.setSelected(true);
      }
}
}

 class CheckBox {
public JPanel getCheckBoxPanel() {
    JPanel checkPanel = new JPanel();
    JCheckBox check = new JCheckBox();
    checkPanel.add(new JLabel("CheckBox"));
    checkPanel.add(check);

    return checkPanel;
}
}