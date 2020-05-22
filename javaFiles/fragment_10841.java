import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BruteForce {

    static transient int Passwords = 0;
    static JFrame frame;

    public static void main(String[] args) {
        //Create and set up the window. 
        frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel textLabel = new JLabel("Passwords tried: " + Passwords, SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);

        //Display the window. 
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        Passwords++;

        new Thread("Test") {
            public void run() {
                while (true) {
                    try {
                        Passwords++;
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                textLabel.setText("Passwords tried: " + Passwords);
                            }
                        });
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BruteForce.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();

    }
}