import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.Timer;
//http://stackoverflow.com/questions/8670297/make-java-swing-modal-dialog-behave-like-mac-osx-dialogs
public class ModalDialogDemoFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private ModalDialogDemoFrame modalDialogDemo;

    public ModalDialogDemoFrame() {
        modalDialogDemo = this;
        setBounds(100, 100, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton buttonDialog = new JButton("Open Dialog");
        buttonDialog.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                // Create a Modal Dialog with this Frame as Parent.
                ModalDialog modalDialog = new ModalDialog(modalDialogDemo, true);
                modalDialog.setVisible(true);
            }
        });
        getContentPane().add(buttonDialog, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    ModalDialogDemoFrame window = new ModalDialogDemoFrame();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
//http://stackoverflow.com/questions/4577424/distinguish-between-a-single-click-and-a-double-click-in-java/4577475#4577475
class ClickListener extends MouseAdapter implements ActionListener {

    private final static int clickInterval = (Integer) Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval");
    private MouseEvent lastEvent;
    private Timer timer;

    public ClickListener() {
        this(clickInterval);
    }

    public ClickListener(int delay) {
        timer = new Timer(delay, this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() > 2) {
            return;
        }
        lastEvent = e;
        if (timer.isRunning()) {
            timer.stop();
            doubleClick(lastEvent);
        } else {
            timer.restart();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        singleClick(lastEvent);
    }

    public void singleClick(MouseEvent e) {
    }

    public void doubleClick(MouseEvent e) {
    }
}

class ModalDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    public ModalDialog(JFrame parent, boolean modal) {
        Dimension dimensionParentFrame = parent.getSize();
        setSize(new Dimension((parent == null) ? 300 : dimensionParentFrame.width / 2, 75));
        Dimension dimensionDialog = getSize();
        int x = parent.getX() + ((dimensionParentFrame.width - dimensionDialog.width) / 2);
        setLocation(x, parent.getY() + parent.getInsets().top);
        //setUndecorated(true);
        setModal(modal);
        //setUndecorated(true);
        //getRootPane().setWindowDecorationStyle(JRootPane.ERROR_DIALOG);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final JButton buttonClose = new JButton("Close");
        buttonClose.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
//ok
                /*JOptionPane.showMessageDialog(buttonClose,
                "Eggs are not supposed to be green.",
                "Inane warning",
                JOptionPane.WARNING_MESSAGE);*/
//uncomment for un_handled GUI, JOptionPane is behing JFrame I think....
                /*JOptionPane.showInternalMessageDialog(buttonClose,
                "Eggs are not supposed to be green.",
                "Inane warning",
                JOptionPane.WARNING_MESSAGE);*/
//ok
                /*JOptionPane.showConfirmDialog(buttonClose,
                "Eggs are not supposed to be green.",
                "Inane warning",
                JOptionPane.WARNING_MESSAGE);*/
//ok                
                /*JOptionPane.showMessageDialog(null,
                "Eggs are not supposed to be green.",
                "Inane warning",
                JOptionPane.WARNING_MESSAGE);*/
//uncomment for un_handled GUI
//Exception occurred during event dispatching:
//java.lang.RuntimeException: JOptionPane: parentComponent does not have a valid parent                
                /*JOptionPane.showInternalMessageDialog(null,
                "Eggs are not supposed to be green.",
                "Inane warning",
                JOptionPane.WARNING_MESSAGE);*/
//ok                
                JOptionPane.showConfirmDialog(null,
                        "Eggs are not supposed to be green.",
                        "Inane warning",
                        JOptionPane.WARNING_MESSAGE);
                dispose();
            }
        });
        add(buttonClose, BorderLayout.CENTER); // comment for listening
        addMouseListener(new ClickListener() {

            @Override
            public void singleClick(MouseEvent e) {
                System.out.println("single");
            }

            @Override
            public void doubleClick(MouseEvent e) {
                System.out.println("double");
            }
        });
    }
}