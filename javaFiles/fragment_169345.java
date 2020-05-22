final TableCellRenderer header = table.getTableHeader().getDefaultRenderer();
table.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
  @Override
  public Component getTableCellRendererComponent(JTable table,
      Object value, boolean isSelected, boolean hasFocus, int row,
      int column) {
    Component tableCellRendererComponent = header.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    String columnHeader = table.getColumnModel().getColumn(column)
        .getHeaderValue().toString();
    ((JComponent) tableCellRendererComponent).setToolTipText(columnHeader);
    return tableCellRendererComponent;
  }
});