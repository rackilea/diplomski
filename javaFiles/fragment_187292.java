import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.*;

public class CaseForLayoutsNumber547 {

    CaseForLayoutsNumber547() {
        Border titledBorder1 = new TitledBorder("Case for Layouts #547");
        // START: code snippet variant
        JPanel panelMain = new JPanel(new GridLayout());
        panelMain.setBorder(titledBorder1);

        JTextArea fieldBody = new JTextArea(5,40);
        JScrollPane fieldBodyScrollPane = new JScrollPane(fieldBody);
        panelMain.add(fieldBodyScrollPane);
        // END: code snippet variant
        JOptionPane.showMessageDialog(null, panelMain);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CaseForLayoutsNumber547();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}