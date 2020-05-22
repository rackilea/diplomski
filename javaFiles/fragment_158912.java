import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestGUI {
    public TestGUI() {
        final JFrame frame = new JFrame("Test");
        JButton press = new JButton("Press Me");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(press);
        press.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                final JDialog dialog = new JDialog();
                dialog.add(new JLabel("Here for 2 seconds"));
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                Timer timer = new Timer(2000, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                        dialog.dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestGUI();
            }
        });
    }
}