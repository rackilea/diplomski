import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ButtonPressTest extends JPanel {
    private JButton button = new JButton("Button");
    private JTextArea textArea = new JTextArea(15, 15);

    public ButtonPressTest() {
        button.getModel().addChangeListener(new BtnModelListener());
        textArea.setFocusable(false);
        add(button);
        add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                                      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
    }

    private class BtnModelListener implements ChangeListener {
        private boolean pressed = false;  // holds the last pressed state of the button

        @Override
        public void stateChanged(ChangeEvent e) {
            ButtonModel model = (ButtonModel) e.getSource();

            // if the current state differs from the previous state
            if (model.isPressed() != pressed) {
                String text = "Button pressed: " + model.isPressed() + "\n"; 
                textArea.append(text);
                pressed = model.isPressed();
            }
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("ButtonPressTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ButtonPressTest());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}