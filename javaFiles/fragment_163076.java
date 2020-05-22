import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

@SuppressWarnings("serial")
public class First2 extends JPanel {
    private static final int COLS = 15;
    private JTextField sourceField = new JTextField(COLS);
    private JTextField destField = new JTextField(COLS);
    private JDialog dialog;
    private DialogPanel dialogPanel = new DialogPanel();

    public First2() {
        setLayout(new GridBagLayout());
        add(new JLabel("Source:"), createGbc(0, 0));
        add(sourceField, createGbc(1, 0));

        add(new JLabel("Destination:"), createGbc(0, 1));
        add(destField, createGbc(1, 1));

        add(new JButton(new CopyAction("Copy")), createGbc(1, 2));
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(4, 4, 4, 4);
        return gbc;
    }

    private class CopyAction extends AbstractAction {
        public CopyAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String src = sourceField.getText();
            String dest = destField.getText();

            MyWorker myWorker = new MyWorker(src, dest);
            myWorker.addPropertyChangeListener(new WorkerListener());
            myWorker.execute();

            Window window = SwingUtilities.getWindowAncestor(First2.this);
            dialog = new JDialog(window, "File Copy", ModalityType.APPLICATION_MODAL);
            dialog.add(dialogPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    }

    private class MyWorker extends SwingWorker<Void, Void> {
        private String src;
        private String dest;

        public MyWorker(String src, String dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        protected Void doInBackground() throws Exception {
            FileUtils.copyDirectory(src, dest);
            return null;
        }
    }

    private class WorkerListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                if (dialog != null && dialog.isVisible()) {
                    dialog.dispose();
                }
                try {
                    ((MyWorker) evt.getSource()).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createAndShowGui() {
        First2 mainPanel = new First2();

        JFrame frame = new JFrame("First2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
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

class DialogPanel extends JPanel {
    private static final int PREF_W = 300;
    private static final int PREF_H = 250;

    public DialogPanel() {
        setLayout(new GridBagLayout());
        add(new JLabel("Copy in Progress..."));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }
}