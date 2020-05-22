import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestListener {

    public static void main(String[] args) {
        new TestListener();
    }

    public TestListener() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JLabel capsStateLabel;

        public TestPane() {
            setLayout(new GridBagLayout());
            capsStateLabel = new JLabel();
            add(capsStateLabel);
            updateLabelState();
            Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {

                @Override
                public void eventDispatched(AWTEvent event) {
                    if (event instanceof KeyEvent) {

                        KeyEvent ke = (KeyEvent) event;
                        switch (ke.getKeyCode()) {
                            case KeyEvent.VK_CAPS_LOCK:
                                switch (ke.getID()) {
                                    case KeyEvent.KEY_PRESSED:
                                    case KeyEvent.KEY_RELEASED:
                                        updateLabelState();
                                        break;
                                }
                                break;
                        }

                    }
                }

            }, KeyEvent.KEY_EVENT_MASK);
        }

        protected void updateLabelState() {
            boolean capsState = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
            if (capsState) {
                capsStateLabel.setText("Caps is ON");
            } else {
                capsStateLabel.setText("Caps is OFF");
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}