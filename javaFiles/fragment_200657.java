import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CustomDialog extends JDialog {
    private JPanel myPanel = null;
    private JButton yesButton = null;
    private JButton noButton = null;

    public CustomDialog(JFrame frame, boolean modal, String myMessage) {
    super(frame, modal);
    myPanel = new JPanel();
    getContentPane().add(myPanel);
    myPanel.add(new JLabel(myMessage));
    yesButton = new JButton("Yes");
    myPanel.add(yesButton);
    noButton = new JButton("No");
    myPanel.add(noButton);
    pack();
    //setLocationRelativeTo(frame);
    setLocation(200, 200); // <--
    setVisible(true);
    }
}