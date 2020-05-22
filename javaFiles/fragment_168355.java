public class PriorityCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        if (Integer.valueOf(1).equals(table.getValueAt(row, 1))) {
            setForeground(Color.RED);  // or background
        }
        return this;
    }
}