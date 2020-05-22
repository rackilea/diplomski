import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WindowTest extends JFrame implements ActionListener,
    WindowListener, WindowFocusListener, WindowStateListener {

    public static final void main(String args[]) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new WindowTest("One");
                new WindowTest("Two");
            }
        });
    }

    public WindowTest(String name) {
        super(name);
        this.setName(name);
        this.setLayout(new GridLayout(0, 1));
        createButton("Back");
        createButton("Front");
        createButton("Hide");
        this.addWindowListener(this);
        this.addWindowFocusListener(this);
        this.addWindowStateListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    private void createButton(String name) {
        JButton b = new JButton(name);
        this.add(b);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if ("Back".equals(s)) {
            this.toBack();
        } else if ("Front".equals(s)) {
            this.toFront();
        } else {
            this.setExtendedState(JFrame.ICONIFIED);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        System.out.println(e);
    }

}