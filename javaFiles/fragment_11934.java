public class HeaderRenderer implements UIResource, TableCellRenderer {

    private TableCellRenderer original;

    public HeaderRenderer(TableCellRenderer original) {
        this.original = original;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                                                                 Object value, boolean isSelected, boolean hasFocus, int row,
                                                                                                 int column) {
        Component comp = original.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        comp.setFont(comp.getFont().deriveFont(Font.BOLD));
        return comp;
    }

}