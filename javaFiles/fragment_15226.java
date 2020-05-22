import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestSwingWorker02 {

    public static void main(String[] args) {
        new TestSwingWorker02();
    }

    public TestSwingWorker02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            JProgressBar pb = new JProgressBar();
            add(pb);

            new ProgressWorker(pb, 40).execute();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class ProgressWorker extends SwingWorker<Void, Integer> {

        private int delay;
        private JProgressBar pb;

        public ProgressWorker(JProgressBar progressBar, int delay) {
            this.pb = progressBar;
            this.delay = delay;
        }

        @Override
        protected void process(List<Integer> chunks) {
            // Back in the EDT...
            pb.setValue(chunks.get(chunks.size() - 1)); // only care about the last one...
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (int index = 0; index < 100; index++) {
                publish(index);
                Thread.sleep(delay);
            }
            return null;
        }

        @Override
        protected void done() {
            // Back in the EDT...
            //pii.dispose();
            //o.Eros();
        }

    }

}