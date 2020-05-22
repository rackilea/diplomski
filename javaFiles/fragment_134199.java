import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/** @see http://stackoverflow.com/questions/5540354 */
public class DialogClose extends JDialog {

    public DialogClose() {
        this.setLayout(new GridLayout(0, 1));
        this.add(new JLabel("Dialog close test.", JLabel.CENTER));
        this.add(new JButton(new AbstractAction("Close") {

            @Override
            public void actionPerformed(ActionEvent e) {
                DialogClose.this.setVisible(false);
                DialogClose.this.dispatchEvent(new WindowEvent(
                    DialogClose.this, WindowEvent.WINDOW_CLOSING));
            }
        }));
    }

    private void display() {
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new DialogClose().display();
            }
        });
    }
}