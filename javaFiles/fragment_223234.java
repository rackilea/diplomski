public class CenterRenderer implements TableCellRenderer {
    private final JTableHeader header;

    public CenterRenderer(JTableHeader header) {
        this.header = header;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) header.getDefaultRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
}