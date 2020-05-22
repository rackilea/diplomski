import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestColorChooser {

    protected void initUI() {
        JFrame frame = new JFrame(TestColorChooser.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel() {
            @Override
            public java.awt.Dimension getPreferredSize() {
                return new Dimension(400, 400);
            };
        };
        final JButton button = new JButton("Click me to change color");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Window parentWindow = SwingUtilities.windowForComponent(button);
                final JColorChooser chooser = new JColorChooser(panel.getBackground());
                chooser.getSelectionModel().addChangeListener(new ChangeListener() {

                    @Override
                    public void stateChanged(ChangeEvent e) {
                        panel.setBackground(chooser.getColor());
                    }
                });
                JDialog dialog = new JDialog(parentWindow);
                dialog.add(chooser);
                dialog.pack();
                dialog.setLocation(panel.getLocationOnScreen().x + panel.getWidth(), panel.getLocationOnScreen().y);
                dialog.setVisible(true);
            }
        });
        frame.add(panel);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestColorChooser().initUI();
            }
        });
    }
}