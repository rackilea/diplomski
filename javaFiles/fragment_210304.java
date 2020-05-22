import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class SimpleKeyBindDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame("Demo");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(new JLabel("Type Esc to exit"));

                // get the contentPane of the frame
                JPanel panel = (JPanel)frame.getContentPane();
                // bind the Escape key to the contentPane
                addKeyBindToComponent(panel, "ESCAPE", "random");

                frame.setSize(400,  400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private static void addKeyBindToComponent(
            JComponent component, String key, String identifier) {

        InputMap imap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        imap.put(KeyStroke.getKeyStroke(key), identifier);
        ActionMap amap = component.getActionMap();
        amap.put(identifier, new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}