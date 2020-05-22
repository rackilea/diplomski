import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

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

        SwingWorker worker = new SwingWorker<Integer, Integer>() {

            @Override
            protected void process(List<Integer> chunks) {

                // Only care about the last one..
                int value = chunks.get(chunks.size() - 1);
                textLabel.setText("Passwords tried: " + value);

            }

            @Override
            protected Integer doInBackground() throws Exception {
                while (true) {
                // Perform long running process...
                    // Forced delay to simulate long running process
                    Thread.sleep(5);
                    Passwords++;
                    publish(Passwords);
                }
            }
        };
        worker.execute();

    }
}