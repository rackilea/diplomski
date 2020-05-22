import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Foo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createGui());
    }

    public static void createGui() {
        Integer[][] rowData = { { 1, 2 }, { 3, 4 } };
        String[] columnNames = { "A", "B" };
        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        int condition = JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
        // int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        // int condition = JComponent.WHEN_FOCUSED;
        InputMap inputMap = table.getInputMap(condition);
        ActionMap actionMap = table.getActionMap();

        KeyStroke saveKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
        KeyStroke pasteKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK);

        String pasteKey = (String) inputMap.get(pasteKeystroke);
        System.out.println(pasteKey);

        inputMap.put(saveKeystroke, saveKeystroke.toString());
        inputMap.put(pasteKeystroke, pasteKeystroke.toString());

        actionMap.put(saveKeystroke.toString(), new MyAction("Save Action"));
        actionMap.put(pasteKeystroke.toString(), new MyAction("Paste Action"));

        JFrame frame = new JFrame("Foo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

@SuppressWarnings("serial")
class MyAction extends AbstractAction {
    private String text;

    public MyAction(String text) {
        this.text = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(text);
    }
}