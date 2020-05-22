import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/** @see http://stackoverflow.com/questions/6163606 */
public class DialogEventTest extends JDialog {

    public DialogEventTest() {
        this.setLayout(new GridLayout(0, 1));
        this.add(new JLabel("Dialog event test.", JLabel.CENTER));
        this.add(new JButton(new AbstractAction("Close") {

            @Override
            public void actionPerformed(ActionEvent e) {
                DialogEventTest.this.setVisible(false);
                DialogEventTest.this.dispatchEvent(new WindowEvent(
                    DialogEventTest.this, WindowEvent.WINDOW_CLOSING));
            }
        }));
    }

    private static class WindowHandler extends WindowAdapter {

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println(e);
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println(e);
        }
    }

    private void display() {
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowHandler());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new DialogEventTest().display();
            }
        });
    }
}