public class IconTextCellRemderer extend DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table,
                                  Object value,
                                  boolean isSelected,
                                  boolean hasFocus,
                                  int row,
                                  int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setText(...);
        setIcon(...);
        setToolTipText(...);
        return this;
    }
}