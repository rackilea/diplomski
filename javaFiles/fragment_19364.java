public class BarTableCellRenderer implements TableCellRenderer {
    private final BarRenderer rendererComponent = new BarRenderer(0, 10);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        rendererComponent.setXval((Integer)value);
        return rendererComponent;
    }
}