import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LongRunningTask {

    public static void main(String[] args) {
        new LongRunningTask();
    }

    public LongRunningTask() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                new BackgroundWorker().start();

            }
        });
    }

    public class BackgroundWorker extends SwingWorker<Object, Object> {

        private JFrame frame;

        public BackgroundWorker() {
        }

        // Cause exeute is final :P
        public void start() {
            ImageIcon icon = new ImageIcon(getClass().getResource("/spinner.gif"));
            JLabel label = new JLabel("This might take some time");
            label.setIcon(icon);

            frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridBagLayout());
            frame.add(label);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            execute();
        }

        @Override
        protected Object doInBackground() throws Exception {

            System.out.println("Working hard...");
            Thread.sleep(1000 + (((int)Math.round(Math.random() * 5)) * 1000));
            System.out.println("Or hardly working...");

            return null;

        }

        @Override
        protected void done() {
            frame.dispose();
        }

    }
}