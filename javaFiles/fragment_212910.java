import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class TestingDialog2 extends JPanel {
    private static final int TIMER_DELAY = 3000;
    private JButton button = new JButton("Press Me");

    public TestingDialog2() {
        button.getModel().addChangeListener(new ModelListener());

        setPreferredSize(new Dimension(300, 200));
        add(button);

        new Timer(TIMER_DELAY, e -> {
            JOptionPane.showMessageDialog(TestingDialog2.this, "Message");
            ((Timer) e.getSource()).stop();
        }).start();
    }

    private class ModelListener implements ChangeListener {
        private boolean pressed = false;

        @Override
        public void stateChanged(ChangeEvent e) {
            boolean modelPressed = ((ButtonModel) e.getSource()).isPressed();
            if (modelPressed != pressed) {
                pressed = modelPressed;
                System.out.println("Pressed: " + pressed);
            }
        }
    }

    private static void createAndShowGui() {
        TestingDialog2 mainPanel = new TestingDialog2();

        JFrame frame = new JFrame("TestingDialog2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}