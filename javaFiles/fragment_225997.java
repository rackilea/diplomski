import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                IdleDialog dialog = new IdleDialog(5, (Window) null, "Testing");
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dialog.add(new TestPane());
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(new JLabel("This is a bad idea"), gbc);
            add(new JButton("Don't tell me"), gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class IdleDialog extends JDialog {

        private long timeOut = 90 * 1000;
        private long startTime;
        private Timer timer;
        private String originalTitle;

        public IdleDialog(long timeOut) {
            init(timeOut);
        }

        public IdleDialog(long timeOut, Frame owner) {
            super(owner);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Frame owner, boolean modal) {
            super(owner, modal);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Frame owner, String title) {
            super(owner, title);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Frame owner, String title, boolean modal) {
            super(owner, title, modal);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
            super(owner, title, modal, gc);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Dialog owner) {
            super(owner);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Dialog owner, boolean modal) {
            super(owner, modal);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Dialog owner, String title) {
            super(owner, title);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Dialog owner, String title, boolean modal) {
            super(owner, title, modal);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
            super(owner, title, modal, gc);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Window owner) {
            super(owner);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Window owner, ModalityType modalityType) {
            super(owner, modalityType);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Window owner, String title) {
            super(owner, title);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Window owner, String title, ModalityType modalityType) {
            super(owner, title, modalityType);
            init(timeOut);
        }

        public IdleDialog(long timeOut, Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
            super(owner, title, modalityType, gc);
            init(timeOut);
        }

        protected void init(double timeOutValue) {

            this.timeOut = Math.round(timeOutValue * 1000);

            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    long runningTime = System.currentTimeMillis() - startTime;
                    System.out.println(runningTime + "/" + timeOut);
                    if (runningTime >= timeOut) {
                        timer.stop();
                        dispose();
                    } else {
                        String title = originalTitle + " [" + (((timeOut - runningTime) / 1000) + 1) + "]";
                        setTitle(title);
                    }
                }
            });

            originalTitle = getTitle();
            String title = originalTitle + " [" + ((timeOut / 1000)) + "]";
            setTitle(title);
            addPropertyChangeListener("title", new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (!timer.isRunning()) {
                        originalTitle = (String) evt.getNewValue();
                    }
                }
            });

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                        timer.start();
                }

                @Override
                public void windowClosed(WindowEvent e) {
                    timer.stop();
                }

            });

            Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
                @Override
                public void eventDispatched(AWTEvent event) {
                    Object source = event.getSource();
                    if (source instanceof Component) {
                        Window win = null;
                        if (!(source instanceof Window)) {
                            win = SwingUtilities.getWindowAncestor((Component) source);
                        } else {
                            win = (Window) source;
                        }
                        if (IdleDialog.this.equals(win)) {
                            if (win.isVisible() && timer.isRunning()) {
                                resetTimeout();
                            }
                        }
                    }
                }
            }, AWTEvent.ACTION_EVENT_MASK
                            | AWTEvent.ADJUSTMENT_EVENT_MASK
                            | AWTEvent.COMPONENT_EVENT_MASK
                            | AWTEvent.CONTAINER_EVENT_MASK
                            | AWTEvent.FOCUS_EVENT_MASK
                            | AWTEvent.HIERARCHY_BOUNDS_EVENT_MASK
                            | AWTEvent.HIERARCHY_EVENT_MASK
                            | AWTEvent.INPUT_METHOD_EVENT_MASK
                            | AWTEvent.INVOCATION_EVENT_MASK
                            | AWTEvent.ITEM_EVENT_MASK
                            | AWTEvent.KEY_EVENT_MASK
                            | AWTEvent.MOUSE_EVENT_MASK
                            | AWTEvent.MOUSE_MOTION_EVENT_MASK
                            | AWTEvent.MOUSE_WHEEL_EVENT_MASK
                            | //                            AWTEvent.PAINT_EVENT_MASK |
                            AWTEvent.TEXT_EVENT_MASK
                            | AWTEvent.WINDOW_EVENT_MASK
                            | AWTEvent.WINDOW_FOCUS_EVENT_MASK
                            | AWTEvent.WINDOW_STATE_EVENT_MASK
            );
        }

        public void resetTimeout() {
            timer.restart();
            startTime = System.currentTimeMillis();
            String title = originalTitle + " [" + ((timeOut / 1000)) + "]";
            setTitle(title);
        }

    }

}