import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

@SuppressWarnings("serial")
public class ProgressFun extends JPanel {
    private JProgressBar progressBar = new JProgressBar(0, 100);

    public ProgressFun() {
        progressBar.setStringPainted(true);
        final JButton startProgress = new JButton("Start Progress");
        startProgress.setMnemonic(KeyEvent.VK_S);
        startProgress.addActionListener(l -> {
            startProgress.setEnabled(false);
            progressBar.setValue(0);
            final MyWorker myWorker = new MyWorker();
            myWorker.execute();

            myWorker.addPropertyChangeListener(pcEvent -> {
                if (pcEvent.getPropertyName().equals("progress")) {
                    int value = (int) pcEvent.getNewValue();
                    progressBar.setValue(value);
                } else if (pcEvent.getNewValue() == SwingWorker.StateValue.DONE) {
                    startProgress.setEnabled(true);
                    try {
                        myWorker.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });
        });

        add(progressBar);
        add(startProgress);
    }

    private static void createAndShowGui() {
        ProgressFun mainPanel = new ProgressFun();

        JFrame frame = new JFrame("Progress Fun");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class MyWorker extends SwingWorker<Void, Integer> {

    @Override
    protected Void doInBackground() throws Exception {
        int progress = 0;
        setProgress(progress);
        while (progress < 100) {
            progress += (int)(5 * Math.random());
            progress = Math.min(progress, 100);
            TimeUnit.MILLISECONDS.sleep((int) (500 * Math.random()));
            setProgress(progress);
        }
        return null;
    }
}