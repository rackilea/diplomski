import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestDialog {

    protected void initUI() {
        JFrame frame = new JFrame(TestDialog.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JButton button = new JButton("Click me to open dialog");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Window parentWindow = SwingUtilities.windowForComponent(button);
                JDialog dialog = new JDialog(parentWindow);
                dialog.setLocationRelativeTo(button);
                dialog.setModal(true);
                dialog.add(new JLabel("A dialog"));
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestDialog().initUI();
            }
        });
    }
}