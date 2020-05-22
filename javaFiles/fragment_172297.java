// Get the column header for your specific column
JTableHeader th = table.getTableHeader();
TableColumnModel tcm = th.getColumnModel();
TableColumn tc = tcm.getColumn(column);

/* Create a new renderer for column headers, and
pass in the column number so you can differntiate
which column will be which color. */
tc.setCellRenderer(new headerCellRenderer(column));