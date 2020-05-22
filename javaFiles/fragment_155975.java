import java.awt.event.*;
import javax.swing.*;

public class ButtonTest {

    private JFrame frame;

    public void createAndShowGUI() {
        frame = new JFrame();
        frame.add(new JButton("Please press ENTER"));
        frame.setLocation(150, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        setKeyBindings();
    }

    private void setKeyBindings() {
        frame.getRootPane().getInputMap(
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
                KeyStroke.getKeyStroke("ENTER"), "clickENTER");
        frame.getRootPane().getActionMap().put("clickENTER", new AbstractAction() {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ButtonTest().createAndShowGUI();
            }
        });
    }
}