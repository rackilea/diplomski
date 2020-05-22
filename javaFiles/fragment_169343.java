final TableCellRenderer renderer = table.getDefaultRenderer(Object.class);
table.setDefaultRenderer(Object.class, new TableCellRenderer() {
  @Override
  public Component getTableCellRendererComponent(JTable table,
      Object value, boolean isSelected, boolean hasFocus, int row,
      int column) {
    Component component = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    String columnHeader = table.getColumnModel().getColumn(column).getHeaderValue().toString();
    ((JComponent) component).setToolTipText(columnHeader);
    return component;
  }
});