import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FocusTransferTest {

    public static void main(String[] args) {
        JFrame frm = new JFrame("Test focus transfer");
        JPanel panel = new JPanel();
        panel.add(new JTextField(10));
        panel.add(new JTextField(10));
        panel.add(new JTextField(10));
        JButton btn = new JButton("Press me");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frm, "It's a message", "Info", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(btn);
        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEnterKeyListener(), 
                AWTEvent.KEY_EVENT_MASK);
        frm.add(panel);
        frm.pack();
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    private static class AWTEnterKeyListener implements AWTEventListener {

        @Override
        public void eventDispatched(AWTEvent event) {
            if (event instanceof KeyEvent) {
                KeyEvent key = (KeyEvent) event;
                if (key.getKeyCode() == KeyEvent.VK_ENTER  && key.getModifiersEx() == 0 
                        && key.getID() == KeyEvent.KEY_PRESSED) {
                    if (key.getComponent() instanceof AbstractButton) {
                        ((AbstractButton) key.getComponent()).doClick();
                    } else {
                        key.getComponent().transferFocus();
                    }
                }
            }
        }

    }
}