import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonBinding {

    private JPanel contentPane;
    private JTextField tField;
    private JButton button;
    private KeyStroke keyStroke = KeyStroke.getKeyStroke("ENTER");

    private Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("Action Performed");
            contentPane.setBackground(Color.BLUE);
        }
    };

    private MouseAdapter mouseActions = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent me) {
            System.out.println("Mouse Entered");
            JButton button = (JButton) me.getSource(); 
            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "enter");
            button.getActionMap().put("enter", action);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            System.out.println("Mouse Exited");
            JButton button = (JButton) me.getSource();
            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "none");
            contentPane.setBackground(Color.RED);
        }
    };  

    private void displayGUI() {
        JFrame frame = new JFrame("Button Binding Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setOpaque(true);
        tField = new JTextField(10);
        button = new JButton("Click Me");
        button.addMouseListener(mouseActions);

        contentPane.add(tField);
        contentPane.add(button);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new ButtonBinding().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}