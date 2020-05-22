import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

@SuppressWarnings("serial")
public class Main4b extends JPanel {
    private static final int MAX = 10000;
    private static final int PREF_W = 400;
    private static final int PREF_H = 200;
    private ButtonAction buttonAction = new ButtonAction();
    private JButton button = new JButton(buttonAction);
    private JTextField jTextField1 = new JTextField("jTextField1", 10);
    private JLabel jLabel1 = new JLabel("jLabel1");
    private JProgressBar jProgressBar1 = new JProgressBar(0, MAX);

    public Main4b() {
        jProgressBar1.setStringPainted(true);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JPanel() {{add(button);}});
        add(new JPanel() {{add(jTextField1);}});
        add(new JPanel() {{add(jLabel1);}});
        add(jProgressBar1);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension superSz = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSz;
        }
        int prefW = Math.max(superSz.width, PREF_W);
        int prefH = Math.max(superSz.height, PREF_H);
        return new Dimension(prefW, prefH);
    }

    private class ButtonAction extends AbstractAction {
        public ButtonAction() {
            super("Button");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setEnabled(false); // make the button non-pressable

            // create background thread worker
            MyWorker myWorker = new MyWorker();

            // add propertychange listener to it
            myWorker.addPropertyChangeListener(new WorkerListener());

            // run the worker thread
            myWorker.execute();
        }
    }

    // background thread
    private static class MyWorker extends SwingWorker<Void, Integer> {
        private static final String MY_PROGRESS = "my progress";
        private int myProgress = 0;

        @Override
        protected Void doInBackground() throws Exception {
            // all this code is run in a background thread

            // do this twice
            for (int j = 0; j < 2; j++) {

                // iterate from 0 to 10,000
                for (int i = 0; i < MAX; i++) {
                    Thread.sleep(1); // small delay so we can see what we're doing
                    setMyProgress(i + j * MAX); // send output to listeners
                }
            }
            return null;
        }

        public int getMyProgress() {
            return myProgress;
        }

        // myProgress is a "bound" field, one that will notify listeners
        // if it is changed
        public void setMyProgress(int myProgress) {
            int oldValue = this.myProgress;
            int newValue = myProgress;
            this.myProgress = myProgress;
            // notify all listeners
            firePropertyChange(MY_PROGRESS, oldValue, newValue);
        }

    }

    private class WorkerListener implements PropertyChangeListener {
        private String message = "Message %d: %05d";

        public WorkerListener() {
            jLabel1.setText(String.format(message, 1, 0));
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            // all this code is run on the Swing event thread

            // listen for changes to my progress bound field
            if (MyWorker.MY_PROGRESS.equals(evt.getPropertyName())) {
                int value = (int) evt.getNewValue(); // get value
                int newMsgIndex = 1 + value / MAX; // message number 
                jProgressBar1.setValue(value % MAX); // set value on progress bar
                jLabel1.setText(String.format(message, newMsgIndex, value % MAX));
            } else if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                // worker is done
                jLabel1.setText(""); // reset JLabel
                buttonAction.setEnabled(true);  // re-enable JButton's Action
                MyWorker myWorker = (MyWorker) evt.getSource();
                try {
                    // always call this to catch and handle any exceptions that 
                    // may have been thrown from within the worker
                    myWorker.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void createAndShowGui() {
        Main4b mainPanel = new Main4b();

        JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}