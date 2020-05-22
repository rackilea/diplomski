import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;

public class JTableBooleanAsCheckbox extends JPanel {

public JTableBooleanAsCheckbox() {
    initializeUI();
}

private void initializeUI() {
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(450, 150));

    JTable table = new JTable(new BooleanTableModel());
    table.setFillsViewportHeight(true);
    JScrollPane pane = new JScrollPane(table);
    add(pane, BorderLayout.CENTER);
}

public static void showFrame() {
    JPanel panel = new JTableBooleanAsCheckbox();
    panel.setOpaque(true);

    JFrame frame = new JFrame("JTable Boolean as Checkbox");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JTableBooleanAsCheckbox.showFrame();
        }
    });
}

class BooleanTableModel extends AbstractTableModel {
    String[] columns = {"STUDENT ID", "NAME", "SCORE", "PASSED"};
    Object[][] data = {
            {"S001", "ALICE", 90.00, Boolean.TRUE},
            {"S002", "BOB", 45.50, Boolean.FALSE},
            {"S003", "CAROL", 60.00, Boolean.FALSE},
            {"S004", "MALLORY", 75.80, Boolean.TRUE}
    };

    public int getRowCount() {
        return data.length;
    }

    public int getColumnCount() {
        return columns.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    //
    // This method is used by the JTable to define the default
    // renderer or editor for each cell. For example if you have
    // a boolean data it will be rendered as a check box. A
    // number value is right aligned.
    //
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return data[0][columnIndex].getClass();
    }
    }
}