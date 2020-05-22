import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class StackOverFlowExample extends JFrame {
    static String oldFileName = "oldFileName";
    private Thread runningThread;

    private class MyDispatcher implements KeyEventDispatcher {
        boolean keyEventDone = false;

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if ((e.getKeyCode() == 80 && e.getModifiers() == 11) && !keyEventDone) {
                    System.out.println("interrupting");
                    interrupt();
                }
            }
            if (e.getID() == KeyEvent.KEY_RELEASED) {
                if (e.getKeyCode() == 80) {
                    keyEventDone = false;
                }
            }
            return true;
        }

    }

    // pass in the correct thread to interrupt
    public void setRunningThread(Thread runningThread) {
        this.runningThread = runningThread;
    }

    public void interrupt() {
        System.out.println("recieved interrupt");
        // !! Thread.currentThread().interrupt();
        runningThread.interrupt();
        System.out.println("interrupt Thread id: " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String fileName = "file Name";
            StackOverFlowExample frame = new StackOverFlowExample();
            frame.setUndecorated(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(217, 104);

            Thread thread = new Thread(() -> {
                do {
                    if (!fileName.equals(oldFileName)) {

                    } else {
                        try {
                            System.out.println("do-while Thread id: " + Thread.currentThread().getId());

                            System.out.println("Same file");
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            System.out.println("continuing");
                            if (Thread.currentThread().isInterrupted()) {
                                System.out.println("continuing");
                                continue;
                            }
                            e.printStackTrace();
                        }
                    }
                    oldFileName = fileName;
                } while (true);
            });

            // pass in the thread
            frame.setRunningThread(thread);
            thread.start(); // start it running
        });
    }

    public StackOverFlowExample() {
        super("");
        JPanel pane = new JPanel();
        pane.setBackground(Color.LIGHT_GRAY);
        setContentPane(pane);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
    }

}