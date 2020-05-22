package progress;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Download extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Download::new);
    }

    private final JButton downloadBtn = new JButton("Start Download");
    private final JProgressBar progressBar = new JProgressBar();
    private final Timer timer = new Timer(200, this::timerTick);

    Download() {
        super("Download Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationByPlatform(true);

        downloadBtn.addActionListener(this::startDownload);
        add(downloadBtn, BorderLayout.PAGE_START);

        progressBar.setStringPainted(true);
        add(progressBar, BorderLayout.PAGE_END);

        setVisible(true);
    }

    private void startDownload(ActionEvent evt) {
        downloadBtn.setEnabled(false);
        timer.start();
        DownloadWorker worker = new DownloadWorker("File1", "FileB", "AnotherFile");
        worker.execute();
    }

    private void timerTick(ActionEvent evt) {
        progressBar.setValue(progressBar.getValue()+2);
    }

    private class DownloadWorker extends SwingWorker<Void, String> {

        private final String[] files;

        DownloadWorker(String ...files) {
            this.files = files;

            progressBar.setValue(0);
        }

        @Override
        protected Void doInBackground() throws Exception {
            for(String file : files) {
                publish(file);

                // Copy the file
                Thread.sleep(3000);  // Pretend copy takes a few seconds
            }
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            String file = chunks.get(chunks.size()-1);  // Just last published filename
            progressBar.setString("Downloading "+file + " ...");
        }

        @Override
        protected void done() {
            progressBar.setString("Complete");
            progressBar.setValue(100);
            timer.stop();
            downloadBtn.setEnabled(true);   // Re-enable UI
        }
    }
}