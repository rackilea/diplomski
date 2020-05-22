import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JButton;


public class ButtonTest extends JFrame implements ActionListener {

    public ButtonTest() {
        super();
        initGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private final List<JButton> buttons = new ArrayList<JButton>();
    private static final int NUM_BUTTONS = 20;

    public void initGUI() {
        JPanel panel = new JPanel();
       for (int i = 0; i < NUM_BUTTONS; i++) {
           String label = "Button " + i;
           JButton button = new JButton(label);
           button.setActionCommand(label);
           button.addActionListener(this);
           buttons.add(button);
           panel.add(button);
       }
       getContentPane().add(panel);
    }

    public static void main(String[] args) {
        new ButtonTest();
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = ((JButton) e.getSource()).getActionCommand();
        System.out.println("Action command for pressed button: " + actionCommand);
        // Use the action command to determine which button was pressed
    }


}