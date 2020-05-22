import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class MigBug extends JFrame {

    public static void main(String args[]) {
        MigBug migbug = new MigBug();
        migbug.pack();
        migbug.setVisible(true);
    }

    public MigBug() {
        JPanel content = new JPanel();
        content.setLayout(new MigLayout("filly, debug", "[][grow][][grow]"));

        content.add(new JLabel("Label 1"));
        content.add(new JComboBox());

        content.add(new JLabel("Label 2"));
        content.add(new JTextField(25), "growx, wrap");

        content.add(new JLabel("BIG"), "span, w :400:, h :200:, grow");

        setContentPane(content);
    }
}