import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;

public class ToolkitAndNumLock {

    private javax.swing.Timer timer = null;
    private JFrame frame = new JFrame();

    public ToolkitAndNumLock() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
        start();
        //uncomment Toolkit.getXxx listening a KeyEvents, you can (start();) block SwingTimer 
        //Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK);
    }
    AWTEventListener listener = new AWTEventListener() {
        @Override
        public void eventDispatched(AWTEvent event) {
            if (event instanceof KeyEvent) {
                KeyEvent ke = (KeyEvent) event;
                if (ke.getID() == KeyEvent.KEY_PRESSED) {
                    if (ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
                        System.out.println("CapsLock Pressed");
                    }
                    if (ke.getKeyCode() == KeyEvent.VK_SCROLL_LOCK) {
                        System.out.println("ScrollLock Pressed");
                    }
                    if (ke.getKeyCode() == KeyEvent.VK_NUM_LOCK) {
                        System.out.println("NumLock Pressed");
                    }
                }
            }
        }
    };

    private void start() {
        timer = new javax.swing.Timer(2500, updateCol());
        timer.setRepeats(true);
        timer.start();
    }

    public Action updateCol() {
        return new AbstractAction("text load action") {
            private static final long serialVersionUID = 1L;
            private Boolean bol = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_NUM_LOCK)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
                if (bol) {
                    Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, true);
                } else {
                    Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, false);
                }
                bol = !bol;
            }
        };
    }

    public static void main(String args[]) {
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                new ToolkitAndNumLock();
            }
        };
        EventQueue.invokeLater(runner);
    }
}