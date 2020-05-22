@Override
public Component getTableCellRendererComponent(JTable table,
    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime((Date) value);
    Component c = super.getTableCellRendererComponent(
        table, value, isSelected, hasFocus, row, col);
    c.setEnabled(calendar.get(Calendar.DAY_OF_MONTH) % 2 == 0);
    return c;
}