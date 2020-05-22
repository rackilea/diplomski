import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 *
 * @author Ryan
 */
public class Test {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                go();
            }
        });
    }

    public static void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Loading...");
        JProgressBar jpb = new JProgressBar();
        jpb.setIndeterminate(false);
        int max = 1000;
        jpb.setMaximum(max);
        panel.add(label);
        panel.add(jpb);
        frame.add(panel);
        frame.pack();
        frame.setSize(200,90);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Task_IntegerUpdate(jpb, max, label).execute();

    }

    static class Task_IntegerUpdate extends SwingWorker<Void, Integer> {

        JProgressBar jpb;
        int max;
        JLabel label;
        public Task_IntegerUpdate(JProgressBar jpb, int max, JLabel label) {
            this.jpb = jpb;
            this.max = max;
            this.label = label;
        }

        @Override
        protected void process(List<Integer> chunks) {
            int i = chunks.get(chunks.size()-1);
            jpb.setValue(i); // The last value in this array is all we care about.
            System.out.println(i);
            label.setText("Loading " + i + " of " + max);
        }

        @Override
        protected Void doInBackground() throws Exception {
            for(int i = 0; i < max; i++) {
                Thread.sleep(10); // Illustrating long-running code.
                publish(i);
            }
            return null;
        }

        @Override
        protected void done() {
            try {
                get();
                JOptionPane.showMessageDialog(jpb.getParent(), "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }   
}