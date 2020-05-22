import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JProgressBar pb;
        private JButton btn;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            btn = new JButton("Go");
            pb = new JProgressBar();

            add(btn, gbc);
            add(pb, gbc);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btn.setEnabled(false);
                    makeItProgress();
                }
            });
        }

        protected void makeItProgress() {
            SwingWorker<Double, Double> worker = new SwingWorker<Double, Double>() {
                @Override
                protected Double doInBackground() throws Exception {
                    Duration duration = Duration.ofSeconds(10);
                    Instant startTime = Instant.now();
                    Duration runningTime = Duration.ZERO;
                    Random rnd = new Random();
                    setProgress(0);
                    do {
                        Thread.sleep(rnd.nextInt(500));
                        Instant now = Instant.now();
                        runningTime = Duration.between(startTime, now);

                        double progress = (double) runningTime.toMillis() / (double) duration.toMillis();
                        setProgress((int) (progress * 100));
                    } while (duration.compareTo(runningTime) >= 0);
                    setProgress(100);
                    return 1.0;
                }
            };
            worker.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    SwingWorker worker = (SwingWorker) evt.getSource();
                    if (evt.getPropertyName().equals("progress")) {
                        int value = (int) evt.getNewValue();
                        pb.setValue(value);
                    } else if (evt.getPropertyName().equals("state") && worker.getState() == SwingWorker.StateValue.DONE) {
                        pb.setValue(100);
                        btn.setEnabled(true);
                    }
                }
            });
            worker.execute();
        }

    }

}