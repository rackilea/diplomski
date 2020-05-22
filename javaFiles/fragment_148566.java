import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VHSInformationPanel extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTable vhsTable;

    public VHSInformationPanel(String[][] data, String[] columnNames) {
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        vhsTable = new JTable(data, columnNames);
        add(new JScrollPane(vhsTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
                BorderLayout.CENTER);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        // setModalityType(ModalityType.APPLICATION_MODAL);
        pack();
        setVisible(true);
    }
}