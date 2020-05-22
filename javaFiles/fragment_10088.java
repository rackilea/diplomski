import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

import sun.swing.SwingUtilities2;

import javax.swing.InternalFrameFocusTraversalPolicy;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;

/*
 * Copy and modified by Oracle sample code "InternalFrameDemo.java"
 */
public class Login extends JFrame {
    JDesktopPane desktop;
    private int m_iFrameCounter = 0;

    /**
     * This class is created to handle problem that program would blink in taskbar 
     * when call setSelected(true) on JInternalFrame base on JRE1.8.0_144, the only different content is
     * use lastFocusOwner.requestFocusInWindow(); instead of lastFocusOwner.requestFocus(); 
     * in method restoreSubcomponentFocus() 
     *
     */
    public class MyInternalFrame extends JInternalFrame {

        private Component lastFocusOwner;
        private final String BASE_JRE_VERSION = "1.8.0_144";

        public MyInternalFrame() {
            _checkJavaVersion();
        }

        public MyInternalFrame(String title) {
            super(title);
            _checkJavaVersion();
        }

        public MyInternalFrame(String title, boolean resizable) {
            super(title, resizable);
            _checkJavaVersion();
        }

        public MyInternalFrame(String title, boolean resizable, boolean closable) {
            super(title, resizable, closable);
            _checkJavaVersion();
        }

        public MyInternalFrame(String title, boolean resizable, boolean closable, boolean maximizable) {
            super(title, resizable, closable, maximizable);
            _checkJavaVersion();
        }

        public MyInternalFrame(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
            super(title, resizable, closable, maximizable, iconifiable);
            _checkJavaVersion();
        }

        private void _checkJavaVersion() {
            if (!BASE_JRE_VERSION.equals(System.getProperty("java.version")))
                System.err.println(String.format("%s is not compatible with current Java runtime version : %s ", this.getClass().toString(), System.getProperty("java.version")));
        }

        @Override
        public void restoreSubcomponentFocus() {
            if (isIcon()) {
                SwingUtilities2.compositeRequestFocus(getDesktopIcon());
            }
            else {
                Component component = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
                if ((component == null) || !SwingUtilities.isDescendingFrom(component, this)) {
                    // FocusPropertyChangeListener will eventually update
                    // lastFocusOwner. As focus requests are asynchronous
                    // lastFocusOwner may be accessed before it has been correctly
                    // updated. To avoid any problems, lastFocusOwner is immediately
                    // set, assuming the request will succeed.
                    setLastFocusOwner(getMostRecentFocusOwner());
                    if (lastFocusOwner == null) {
                        // Make sure focus is restored somewhere, so that
                        // we don't leave a focused component in another frame while
                        // this frame is selected.
                        setLastFocusOwner(getContentPane());
                    }
                    lastFocusOwner.requestFocusInWindow();
                }
            }
        }

        private void setLastFocusOwner(Component component) {
            lastFocusOwner = component;
        }

        @Override
        public Component getMostRecentFocusOwner() {
            if (isSelected()) {
                return getFocusOwner();
            }

            if (lastFocusOwner != null) {
                return lastFocusOwner;
            }

            FocusTraversalPolicy policy = getFocusTraversalPolicy();
            if (policy instanceof InternalFrameFocusTraversalPolicy) {
                return ((InternalFrameFocusTraversalPolicy)policy).
                    getInitialComponent(this);
            }

            Component toFocus = policy.getDefaultComponent(this);
            if (toFocus != null) {
                return toFocus;
            }
            return getContentPane();
        }

        @Override
        public Component getFocusOwner() {
            if (isSelected()) {
                return lastFocusOwner;
            }
            return null;
        }
    }

    public Login() {
        super("InternalFrameDemo");

        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);

        //Set up the GUI.
        desktop = new JDesktopPane(); //a specialized layered pane
        setContentPane(desktop);

        //Make dragging a little faster but perhaps uglier.
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

        // Add new frame every 50 millisecond
        Thread addFrameThread = new Thread() {

            @Override
            public void run() {
                while(true) {
                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            createFrame();
                        }
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        addFrameThread.start();
    }

    //Create a new internal frame.
    protected void createFrame() {
        JInternalFrame frame = new MyInternalFrame();
        frame.setTitle("" + m_iFrameCounter);
        frame.setSize(100, 100);
        frame.setLocation(0, 0);
        frame.setVisible(true); //necessary as of 1.3
        desktop.add(frame);
        frame.moveToFront();
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
        m_iFrameCounter++;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        Login frame = new Login();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}