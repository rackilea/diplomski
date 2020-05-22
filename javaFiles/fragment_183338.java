import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class TestWorker {
    private UIProgress progress;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TestWorker().executeTask();
        });
    }

    public void executeTask() {
        progress = new UIProgress();
        progress.prepareGUI();

        final SwingWorker<Void, Void> myWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // progress.updateProgress (10);
                setProgress(10); // sets the worker's "bound" progress property
                getWorkedItems();

                setProgress(30);
                getWorkedTickets();

                setProgress(50);
                getRemainTickets();

                setProgress(70);

                TimeUnit.SECONDS.sleep(2);

                // ... only further background work goes here
                // no direct Swing calls
                return null;
            }
        };
        myWorker.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                if ("progress".equals(evt.getPropertyName())) {
                    // if the progress property has been changed
                    // get its value and use it to update the GUI
                    progress.updateProgress((int) evt.getNewValue());
                } else if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
                    // worker is done then here notify the GUI
                    progress.updateProgress(100);
                    // perhaps call:
                    // jf.postTriagedTicketDetailsDaily();

                    // call get() on worker to catch and handle exceptions
                    try {
                        myWorker.get();
                    } catch (InterruptedException | ExecutionException e) {
                        // TODO handle the exceptions here
                        e.printStackTrace();
                    }
                }
            }
        });
        myWorker.execute();
    }

    // dummy methods just to demonstrate long-running code
    private void getRemainTickets() {
        mySleep(3);  // emulate long-running code
    }

    private void getWorkedTickets() {
        mySleep(4);
    }

    private void getWorkedItems() {
        mySleep(2);
    }

    private void mySleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {}
    }

    @SuppressWarnings("serial")
    private class UIProgress extends JPanel {
        private static final int PREF_W = 400;
        private static final int PREF_H = 100;
        private JProgressBar progressBar = new JProgressBar(0, 100);
        private JLabel statusLabel = new JLabel(" ");

        public UIProgress() {
            JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
            statusPanel.add(new JLabel("Status:"));
            statusPanel.add(Box.createHorizontalStrut(4));
            statusPanel.add(statusLabel);            

            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
            add(statusPanel, BorderLayout.PAGE_START);
            add(progressBar, BorderLayout.PAGE_END);
        }

        public void prepareGUI() {
            JFrame frame = new JFrame("UI Progress");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(this);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        @Override
        public Dimension getPreferredSize() {
            if (isPreferredSizeSet()) {
                return super.getPreferredSize();
            }
            return new Dimension(PREF_W, PREF_H);
        }

        public void updateProgress(int prog) {
            String text = String.format("Current Progress is %d%%", prog);
            statusLabel.setText(text);
            progressBar.setValue(prog);
        }

    }
}