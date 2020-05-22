public Component getTableCellRendererComponent(JTable table,
        Object value, boolean isSelected, boolean hasFocus, int row,
        int column) {
    ... // configure visuals
    setText((String) value);
    setSize(table.getColumnModel().getColumn(column).getWidth(),
            Short.MAX_VALUE);
    return this;
}// getTableCellRendererComponent