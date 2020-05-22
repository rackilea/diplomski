import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class MainWindow {

    private JFrame _frame;
    private JTextArea _textArea;
    private ProgressBar _progress;

    public MainWindow() {
        _frame = new JFrame("Main Window");
        _textArea = new JTextArea();

        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.add(new JScrollPane(_textArea));
        _frame.setSize(200, 200);;
        _frame.setVisible(true);

        doStuffinBackground();
    }

    private void doStuffinBackground() {
//        _progress = new ProgressBar();
//        ScanWorker scanWorker = new ScanWorker();
//        scanWorker.execute();
//        return scanWorker.get();

        _progress = new ProgressBar();
        ScanWorker worker = new ScanWorker(_textArea, _progress);
        worker.execute();
        _progress.setVisible(true);
    }

    class ProgressBar extends JDialog {

        public ProgressBar() {
            super(_frame, "Scanning", true);

            JProgressBar progressBar = new JProgressBar();
            progressBar.setIndeterminate(true);
            progressBar.setStringPainted(false);

            add(progressBar);

            setTitle("Progress Window");
            pack();
            setLocationRelativeTo(_frame);
        }
    }

    class ScanWorker extends SwingWorker<List<String>, String> {

        private JTextArea textArea;
        private ProgressBar progressBar;

        protected ScanWorker(JTextArea _textArea, ProgressBar _progress) {
            this.textArea = _textArea;
            this.progressBar = _progress;

        }

        @Override
        protected void process(List<String> chunks) {
            for (String value : chunks) {
                textArea.append(value + "\n");
            }
        }

        @Override
        public List<String> doInBackground() throws Exception {
            System.out.println("...");
            int j = 0;
            List<String> results = new ArrayList<>(25);
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                j += 1;
                System.out.println(j);
                results.add(Integer.toString(j));
                publish(Integer.toString(j));
            }
            return results;
        }

        @Override
        protected void done() {
            progressBar.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow();
            }
        });
    }
}