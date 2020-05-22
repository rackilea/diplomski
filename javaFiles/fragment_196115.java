import javax.swing.JTable;

public class CellData {
    private JTable table;

    public CellData(JTable table) {
        this.table = table;
    }

    public int getColumn() {
        return table.getSelectedColumn();
    }

    public String getValue() {
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();
        return (String) table.getValueAt(row, col);
    }

    public JTable getTable() {
        return table;
    }

}