import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ProgressBarEg extends JPanel {
    public ProgressBarEg() {
        add(new JButton(new ShowDialogAction("Show Indeterminant Dialog", KeyEvent.VK_I, true)));
        add(new JButton(new ShowDialogAction("Show Determinant Dialog", KeyEvent.VK_D, false)));
        setPreferredSize(new Dimension(500, 350));
    }

    private class MyWorker extends SwingWorker<Void, Void> {

        private static final int DELTA_PROGRESS = 1;
        private static final long SLEEP_TIME = 40;

        @Override
        protected Void doInBackground() throws Exception {
            int progress = getProgress();
            while (progress < 100) {
                progress += DELTA_PROGRESS;
                progress = Math.min(progress, 100);
                setProgress(progress);
                Thread.sleep(SLEEP_TIME);
            }
            return null;
        }
    }

    private class ShowDialogAction extends AbstractAction {
        JDialog dlgProgress;
        private boolean indeterminant;
        JProgressBar pbProgress = new JProgressBar(0, 100);

        public ShowDialogAction(String name, int mnemonic, boolean indeterminant) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
            this.indeterminant = indeterminant;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (dlgProgress == null) {
                Window window = SwingUtilities.getWindowAncestor(ProgressBarEg.this);
                dlgProgress = new JDialog(window, "Veuillez patienter...", ModalityType.APPLICATION_MODAL);
                JLabel lblStatus = new JLabel("Test");

                if (indeterminant) {
                    pbProgress.setIndeterminate(true);
                } else {
                    pbProgress.setStringPainted(true);
                }

                dlgProgress.add(BorderLayout.NORTH, lblStatus);
                dlgProgress.add(BorderLayout.CENTER, pbProgress);
                dlgProgress.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                //dlgProgress.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dlgProgress.setPreferredSize(new Dimension(300, 90));
                dlgProgress.setLocationRelativeTo(null);
                dlgProgress.pack();
            }

            SwingWorker<Void, Void> sw = new MyWorker();
            sw.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (evt.getPropertyName().equalsIgnoreCase("progress")) {
                        pbProgress.setValue((Integer) evt.getNewValue()); 
                    } else if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                        dlgProgress.dispose();
                    } 
                }
            });

            sw.execute();
            dlgProgress.setVisible(true);

        }
    }

    private static void createAndShowGui() {
        ProgressBarEg mainPanel = new ProgressBarEg();

        JFrame frame = new JFrame("ProgressBarEg");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}