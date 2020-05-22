import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

@SuppressWarnings("serial")
public class ComboEditorEg extends JPanel {
    private MyTableModel model = new MyTableModel();
    private JTable table = new JTable(model);

    public ComboEditorEg() {
        for (int i = 0; i < 10; i++) {
            String textA = i % 2 == 0 ? "SA" : "FN";
            String textB = i % 2 == 0 ? "A" : "B";

            Object[] row = new String[] { textA, textB };
            model.addRow(row);
        }

        table.getColumnModel().getColumn(1).setCellEditor(new MyCellEditor());

        setLayout(new BorderLayout());
        add(new JScrollPane(table));
    }

    private static void createAndShowGui() {
        ComboEditorEg mainPanel = new ComboEditorEg();

        JFrame frame = new JFrame("ComboEditorEg");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}

@SuppressWarnings("serial")
class MyTableModel extends DefaultTableModel {
    public static final String[] COL_NAMES = { "Foo 1", "Foo 2" };

    public MyTableModel() {
        super(COL_NAMES, 0);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
}

@SuppressWarnings("serial")
class MyCellEditor extends AbstractCellEditor implements TableCellEditor {

    DefaultCellEditor other = new DefaultCellEditor(new JTextField());
    DefaultCellEditor checkbox = new DefaultCellEditor(new JComboBox<String>(new String[] { "abc",
            "def", "ghi" }));

    private DefaultCellEditor lastSelected = other; // so it's not null

    @Override
    public Object getCellEditorValue() {

        return lastSelected.getCellEditorValue();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
            int row, int column) {
        if (table.getValueAt(row, column - 1).toString().contains("FN")) {
            lastSelected = checkbox;
            return checkbox.getTableCellEditorComponent(table, value, isSelected, row, column);
        }
        return other.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

}