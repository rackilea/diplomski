import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class TestKeyBinding {

    private JFrame frame;

    public final class PrintAction extends AbstractAction {

        public PrintAction() {
            super("Print");
        }

        @Override
        public final void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, "Perform some printing");
        }
    }

    protected void initUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PrintAction printAction = new PrintAction();
        JButton button = new JButton("Print");
        button.registerKeyboardAction(printAction, KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        button.setAction(printAction);
        JComponent comp = new JComponent() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }
        };
        frame.add(comp, BorderLayout.NORTH);
        frame.add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
        comp.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestKeyBinding().initUI();
            }
        });
    }
}