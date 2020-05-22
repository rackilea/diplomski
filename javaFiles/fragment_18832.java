import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;

/**
* @see https://stackoverflow.com/a/11372932/230513
* @see https://stackoverflow.com/a/3588523/230513
*/
public class WorkerLatchTest extends JApplet {

    private static final int N = 8;
    private static final Random rand = new Random();
    private Queue<JLabel> labels = new LinkedList<JLabel>();
    private JPanel panel = new JPanel(new GridLayout(0, 1));
    private JButton startButton = new JButton(new StartAction("Do work"));

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setTitle("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new WorkerLatchTest().createGUI());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    @Override
    public void init() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                add(new WorkerLatchTest().createGUI());
            }
        });
    }

    private JPanel createGUI() {
        for (int i = 0; i < N; i++) {
            JLabel label = new JLabel("0", JLabel.CENTER);
            label.setOpaque(true);
            panel.add(label);
            labels.add(label);
        }
        panel.add(startButton);
        return panel;
    }

    private class StartAction extends AbstractAction {

        private StartAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                CountDownLatch latch = new CountDownLatch(N);
                ExecutorService executor = Executors.newFixedThreadPool(N);
                for (JLabel label : labels) {
                    label.setBackground(Color.white);
                    executor.execute(new Counter(label, latch));
                }
                new Supervisor(latch).execute();
        }
    }

    private class Supervisor extends SwingWorker<Void, Void> {

        CountDownLatch latch;

        public Supervisor(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        protected Void doInBackground() throws Exception {
            latch.await();
            return null;
        }

        @Override
        protected void done() {
            for (JLabel label : labels) {
                label.setText("Fin!");
                label.setBackground(Color.lightGray);
            }
            startButton.setEnabled(true);
            //panel.removeAll(); panel.revalidate(); panel.repaint();
        }
    }

    private static class Counter extends SwingWorker<Void, Integer> {

        private JLabel label;
        CountDownLatch latch;

        public Counter(JLabel label, CountDownLatch latch) {
            this.label = label;
            this.latch = latch;
        }

        @Override
        protected Void doInBackground() throws Exception {
            int latency = rand.nextInt(42) + 10;
            for (int i = 1; i <= 100; i++) {
                publish(i);
                Thread.sleep(latency);
            }
            return null;
        }

        @Override
        protected void process(List<Integer> values) {
            label.setText(values.get(values.size() - 1).toString());
        }

        @Override
        protected void done() {
            label.setBackground(Color.green);
            latch.countDown();
        }
    }
}