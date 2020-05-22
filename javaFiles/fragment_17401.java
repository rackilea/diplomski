public class TableColorRenderer extends JLabel implements TableCellRenderer {

    public TableColorRenderer() {
        setBackground(Color.GREEN);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Boolean) {
            boolean result = (boolean) value;
            setOpaque(result);
        } else {
            setOpaque(false);
        }
        return this;
    }
}