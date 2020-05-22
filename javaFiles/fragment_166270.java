import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                String targetCell = JOptionPane.showInputDialog(null, "Enter "
                        + "target cellphone number: ");
                JOptionPane.showMessageDialog(null, "Click OK to "
                        + "track the GPS coordinates of " + targetCell + "...");
                SplashPane.showSplashScreen();
                JOptionPane.showMessageDialog(null, "The address located within "
                        + "GPS coordinates is: " /**
                 * + "random fake address") *
                 */
                );
            }
        });
    }

    public static class SplashPane extends JPanel {

        private JProgressBar progressBar = new JProgressBar();
        private Timer timer1;

        public SplashPane() {
            setLayout(new BorderLayout(0, 4));
            setBorder(new EmptyBorder(10, 10, 10, 10));

            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBorder(new CompoundBorder(
                    new javax.swing.border.EtchedBorder(),
                    new EmptyBorder(30, 20, 30, 20)));
            panel.setBackground(Color.green);
            JLabel label = new JLabel("Tracking target GPS coordinates...");
            label.setFont(new Font("Verdana", Font.BOLD, 14));
            panel.add(label);
            add(panel);

            add(progressBar, BorderLayout.SOUTH);

            loadProgressBar();
        }

        private void loadProgressBar() {
            ActionListener al = new ActionListener() {
                private int count;

                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    count = Math.min(100, ++count);
                    progressBar.setValue(count);

                    System.out.println(count);
                    if (count == 100) {
                        SwingUtilities.windowForComponent(SplashPane.this).dispose();
                        timer1.stop();
                    }
                }
            };
            timer1 = new Timer(150, al);
            timer1.start();
        }

        public static void showSplashScreen() {
            JDialog frame = new JDialog();
            frame.setModal(true);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setUndecorated(true);
            frame.add(new SplashPane());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

    }
}