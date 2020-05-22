table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
// on receiving a TableModelEvent which might increase the column width
// calculate new width by measuring pref of the renderer
int newWidth = ... 
// set it as pref of the column 
table.getColumnModel().getColumn(0).setPreferredWidth(newWidth);