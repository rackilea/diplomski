import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DialogsTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame();

                f.setSize(400, 300);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);

                JPanel message = new JPanel();
                message.add(new JLabel("This is a dialog :)"));
                JDialog dialog = new JDialog(f, "Dialog");

                dialog.setContentPane(message);
                dialog.pack();
                dialog.setLocationRelativeTo(f);
                dialog.setVisible(true);
            }
        });
    }
}