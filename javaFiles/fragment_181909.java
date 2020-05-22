import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PMDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private boolean modal = false;
    private WindowAdapter parentWindowListener;
    private Window owner;
    private JFrame blockedFrame = new JFrame("Blocked Frame");
    private JFrame noBlockedFrame = new JFrame("No Blocked Frame");

    public PMDialog() {
        noBlockedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        noBlockedFrame.getContentPane().add(new JButton(new AbstractAction("Test button") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Non blocked button pushed");
                /*if (blockedFrame.isVisible()) {
                noBlockedFrame.setVisible(false);
                } else {
                blockedFrame.setVisible(true);
                }*/
                noBlockedFrame.setVisible(true);
                blockedFrame.setVisible(true);
            }
        }));
        noBlockedFrame.setSize(200, 200);
        noBlockedFrame.setVisible(true);
        blockedFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        blockedFrame.getContentPane().add(new JButton(new AbstractAction("Test Button") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {
                final PMDialog pmd = new PMDialog(blockedFrame, "Partial Modal Dialog", true);
                pmd.setSize(200, 100);
                pmd.setLocationRelativeTo(blockedFrame);
                pmd.getContentPane().add(new JButton(new AbstractAction("Test button") {

                    private static final long serialVersionUID = 1L;

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        System.out.println("Blocked button pushed");
                        pmd.setVisible(false);
                        blockedFrame.setVisible(false);
                        noBlockedFrame.setVisible(true);
                    }
                }));
                pmd.setDefaultCloseOperation(PMDialog.DISPOSE_ON_CLOSE);
                pmd.setVisible(true);
                System.out.println("Returned from Dialog");
            }
        }));
        blockedFrame.setSize(200, 200);
        blockedFrame.setLocation(300, 0);
        blockedFrame.setVisible(false);
    }

    public PMDialog(JDialog parent, String title, boolean isModal) {
        super(parent, title, false);
        initDialog(parent, title, isModal);
    }

    public PMDialog(JFrame parent, String title, boolean isModal) {
        super(parent, title, false);
        initDialog(parent, title, isModal);
    }

    private void initDialog(Window parent, String title, boolean isModal) {
        owner = parent;
        modal = isModal;
        parentWindowListener = new WindowAdapter() {

            @Override
            public void windowActivated(WindowEvent e) {
                if (isVisible()) {
                    System.out.println("Dialog.getFocusBack()");
                    getFocusBack();
                }
            }
        };
    }

    private void getFocusBack() {
        Toolkit.getDefaultToolkit().beep();
        super.setVisible(false);
        super.pack();
        super.setLocationRelativeTo(owner);
        super.setVisible(true);
        super.toFront();
    }

    @Override
    public void dispose() {
        owner.setEnabled(true);
        owner.setFocusableWindowState(true);
        super.dispose();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void hide() {
        owner.setEnabled(true);
        owner.setFocusableWindowState(true);
        super.hide();
    }

    @Override
    public void setVisible(boolean visible) {
        boolean blockParent = (visible && modal);
        owner.setEnabled(!blockParent);
        owner.setFocusableWindowState(!blockParent);
        super.setVisible(visible);
        if (blockParent) {
            System.out.println("Adding listener to parent ...");
            owner.addWindowListener(parentWindowListener);
            try {
                if (SwingUtilities.isEventDispatchThread()) {
                    System.out.println("EventDispatchThread");
                    EventQueue theQueue = getToolkit().getSystemEventQueue();
                    while (isVisible()) {
                        AWTEvent event = theQueue.getNextEvent();
                        Object src = event.getSource();
                        if (event instanceof ActiveEvent) {
                            ((ActiveEvent) event).dispatch();
                        } else if (src instanceof Component) {
                            ((Component) src).dispatchEvent(event);
                        }
                    }
                } else {
                    System.out.println("OUTSIDE EventDispatchThread");
                    synchronized (getTreeLock()) {
                        while (isVisible()) {
                            try {
                                getTreeLock().wait();
                            } catch (InterruptedException e) {
                                break;
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error from EDT ... : " + ex);
            }
        } else {
            System.out.println("Removing listener from parent ...");
            owner.removeWindowListener(parentWindowListener);
            owner.setEnabled(true);
            owner.setFocusableWindowState(true);
        }
    }

    @Override
    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public static void main(String args[]) {
        PMDialog pMDialog = new PMDialog();
    }
}