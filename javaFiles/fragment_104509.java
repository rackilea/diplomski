// Compute the value to be added to the width of the table
//  int initialWidth = table.getColumnModel().getColumn(0).getPreferredWidth();
//  int delta = width - initialWidth;
// Try to resize the table and the first column
//  table.setPreferredSize(new Dimension(table.getPreferredSize().width + delta, table.getHeight()));
table.getColumnModel().getColumn(0).setPreferredWidth(width);