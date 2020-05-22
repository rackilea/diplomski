import java.awt.event.ActionEvent;
import javax.swing.*;

public class Stack {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String[][] data = {{"Data"}};
                String[] cols = {"COlo"};
                JTable table = new JTable(data, cols);

                int focusCondition = JComponent.WHEN_IN_FOCUSED_WINDOW;
                String name = "random";
                String key = "ctrl shift SPACE";
                addKeyBinding(table, name, key, focusCondition);

                JOptionPane.showMessageDialog(null, table);
            }
        });
    }

    private static void addKeyBinding(JComponent component,
            final String name,
            final String key,
            int focusCondition) {
        InputMap iMap = component.getInputMap(focusCondition);
        iMap.put(KeyStroke.getKeyStroke(key), name);
        ActionMap aMap = component.getActionMap();
        aMap.put(name, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Key: " + key + " pressed");
            }
        });
    }
}