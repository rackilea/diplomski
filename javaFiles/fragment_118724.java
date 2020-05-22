int width = 0;
 for (row = 0; row < table.getRowCount(); row++) {
     TableCellRenderer renderer = table.getCellRenderer(row, myColumn);
     Component comp = table.prepareRenderer(renderer, row, myColumn);
     width = Math.max (comp.getPreferredSize().width, width);
 }