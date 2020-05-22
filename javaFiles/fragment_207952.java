import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;


public class TestUndecoratedFrame {

    public static void main(String[] args) {
        final JFrame frame = new JFrame() {
            @Override
            public synchronized void setExtendedState(int state) {
                // undecorated covers task bar - http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4737788
                if (isUndecorated()
                        && (state & MAXIMIZED_BOTH) == MAXIMIZED_BOTH) {
                    super.setMaximizedBounds(com.jidesoft.utils.PortingUtils.getScreenBounds(this, true));
                }
                super.setExtendedState(state);
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setUndecorated(true);
        frame.getContentPane().add(new JButton(new AbstractAction("Toggle maximize") {
            @Override
            public void actionPerformed(ActionEvent e) {
                int state = frame.getExtendedState();
                if((state & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
                    frame.setExtendedState(JFrame.NORMAL);
                }
                else {
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            }
        }), BorderLayout.PAGE_END);
        frame.setVisible(true);
    }
}