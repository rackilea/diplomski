import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TextFieldFromFileChooser {
    public TextFieldFromFileChooser() {
        JFileChooser chooser = new JFileChooser();
        JTextField fileChooserTextField = getFileChooserTextField(chooser);
        fileChooserTextField.setText("I name this file.txt");
        fileChooserTextField.setEditable(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Selected file has the name of the fileChooserTextField' text
            System.out.println(chooser.getSelectedFile().getAbsolutePath());
        }
    }

    private static JTextField getFileChooserTextField(JFileChooser chooser) {
        JTextField f = null;
        for (Component c : getComponents(chooser)) {
            if (c instanceof JTextField){
                f = (JTextField) c;
                break;
            }
        }
        return f;
    }

    private static List<Component> getComponents(JComponent component) {
        List<Component> list = new ArrayList<>();
        for (Component c : component.getComponents()) {
            if (c instanceof JPanel)
                list.addAll(getComponents((JPanel) c));
            else if (c instanceof JTextField)
                list.add((JTextField) c);
        }
        return list;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextFieldFromFileChooser());
    }
}