import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class MyClass {

    private int counter = 0;
    private JLabel showCounter;
    private JButton start;

    public MyClass() {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        start = new JButton("Start");
        start.addActionListener(e -> runProcessStart());
        window.add(start, BorderLayout.PAGE_START);

        showCounter = new JLabel(String.valueOf("Click button to start" ));
        window.add(showCounter, BorderLayout.PAGE_END);
        window.pack();
        window.setVisible(true);
    }

    public void runProcessStart() {

        start.setEnabled(false);

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < 10; i++) {
                    publish(counter++);
                    Thread.sleep(2000);
                }

                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                for (int i : chunks) {
                    showCounter.setText("Process Start running "+ i);
                }
            }

            @Override
            protected void done() {
                showCounter.setText("Process Start finished");
                runProcessEnd();
            }
        };

        worker.execute();
    }

    public void runProcessEnd() {

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(2000);
                    publish(counter--);
                }

                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {

                 for (int i : chunks) {
                     showCounter.setText("Process End running "+ i);
                 }
            }

            @Override
            protected void done() {
                start.setEnabled(true);
                showCounter.setText("All done");
            }
        };

        worker.execute();
    }

    public static void main(String[] args) {
        new MyClass();
    }
}