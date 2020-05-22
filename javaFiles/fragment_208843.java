import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TwoJframes implements WindowStateListener {
    private JFrame frame;
    private JFrame frame2;
    public static void main(String [] args) {
        new TwoJframes().gui();
    }
    private void gui() {
        frame = new JFrame();
        frame.setTitle("JFrame 1");
        JButton button = new JButton("Show Frame 2");
        button.addActionListener(e -> showAnotherFrame());
        frame.addWindowStateListener(this);
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(250, 100);        
        frame.setVisible(true);
    }
    private void showAnotherFrame() {
        frame2 = new JFrame();
        frame2.setTitle("JFrame 2");
        frame2.addWindowStateListener(this);
        frame2.add(new JLabel("2nd frame"));
        frame2.setSize(250, 100);
        frame2.setLocation(300, 300);
        frame2.setVisible(true);
    }
    // This is the WindowStateListener's implementation method
    @Override public void windowStateChanged(WindowEvent e) {
        JFrame f = (JFrame) e.getSource();
        if (f == frame) {
            if ((frame.getExtendedState() == Frame.NORMAL) && 
                    (frame2.getExtendedState() == Frame.ICONIFIED)) {
                frame2.setExtendedState(Frame.NORMAL);
            }
        }
        if (f == frame2) {
            if ((frame2.getExtendedState() == Frame.NORMAL) && 
                    (frame.getExtendedState() == Frame.ICONIFIED)) {
                frame.setExtendedState(Frame.NORMAL);
            }
        }
    }
}