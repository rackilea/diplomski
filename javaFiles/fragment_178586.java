import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class RunFile extends JPanel {
    public static final String TEXT = "Call me Ishmael. Some years ago-never mind how long precisely-having "
            + "little or no money in my purse, and nothing particular to interest me on shore, "
            + "I thought I would sail about a little and see the watery part of the world. "
            + "It is a way I have of driving off the spleen and regulating the circulation. "
            + "Whenever I find myself growing grim about the mouth; whenever it is a damp, "
            + "drizzly November in my soul; whenever I find myself involuntarily pausing before "
            + "coffin warehouses, and bringing up the rear of every funeral I meet; and especially "
            + "whenever my hypos get such an upper hand of me, that it requires a strong moral "
            + "principle to prevent me from deliberately stepping into the street, and methodically "
            + "knocking people's hats off-then, I account it high time to get to sea as soon as I can. "
            + "This is my substitute for pistol and ball. With a philosophical flourish Cato throws himself "
            + "upon his sword; I quietly take to the ship. There is nothing surprising in this. "
            + "If they but knew it, almost all men in their degree, some time or other, cherish "
            + "very nearly the same feelings towards the ocean with me. There now is your insular "
            + "city of the Manhattoes, belted round by wharves as Indian isles by coral reefs-commerce surrounds "
            + "it with her surf. Right and left, the streets take you waterward.";
    private static final int TXT_AREA_ROWS = 20;
    private static final int TXT_AREA_COLS = 40;
    private JTextArea input = new JTextArea(TXT_AREA_ROWS, TXT_AREA_COLS);

    public RunFile() {
        // put jtextarea into scrollpane and allow wrapping of words
        JScrollPane scrollPane = new JScrollPane(input);
        input.setWrapStyleWord(true);
        input.setLineWrap(true);
        input.setFocusable(false);  // make the text area not accept user input

        JPanel bottomButtonPanel = new JPanel();
        // add button that initiates long-running code
        bottomButtonPanel.add(new JButton(new RunFileEvent())); 

        setLayout(new BorderLayout());
        add(scrollPane);
        add(bottomButtonPanel, BorderLayout.PAGE_END);
    }

    // ActionListener for button that runs long-running code
    private class RunFileEvent extends AbstractAction {
        public RunFileEvent() {
            super("Run File");
            putValue(MNEMONIC_KEY, KeyEvent.VK_R);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            input.setText(TEXT);  // display the text
            setEnabled(false);  // in activate the button

            // create the SwingWorker and start it
            MyWorker myWorker = new MyWorker(this);
            myWorker.execute();
        }
    }

    // SwingWorker to run long-running code
    private class MyWorker extends SwingWorker<Void, Void> {
        private RunFileEvent runFileEvent;

        public MyWorker(RunFileEvent runFileEvent) {
            this.runFileEvent = runFileEvent; // pass button's action into worker
        }

        @Override
        protected Void doInBackground() throws Exception {
            // simulate a long-running task with a Thread sleep
            TimeUnit.SECONDS.sleep(4);
            return null;
        }

        @Override
        protected void done() {
            // worker has completed its work
            input.setText("");  // set text area back to empty
            runFileEvent.setEnabled(true);  // re-enable button
            try {
                get();  // call this to capture and handle any exceptions thrown by worker
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("RunFile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RunFile());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}