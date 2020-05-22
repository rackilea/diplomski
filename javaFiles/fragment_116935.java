for (int i = 0; i < table.getColumnCount(); i++) {
    TableColumn column = table.getColumnModel().getColumn(i);
    if (i == COLOR_COLUMN) { // COLOR_COLUMN = 1
        column.setCellRenderer(new StatusColumnCellRenderer());
    } else { 
        column.setCellRenderer(centerRenderer);
    }
}