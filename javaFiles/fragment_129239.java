public Component getTableCellRendererComponent(
                        JTable table, Object color,
                        boolean isSelected, boolean hasFocus,
                        int row, int column) {
    // Prepare renderer as usual...

    // Check to see if the current row/column is within 
    // the acceptable range...
    // It would be usful if this information was coming from
    // some kind of model
    if (row == iconRow && column == iconColumn) {
        // Apply the icon for this cell renderer
    }
    return this;
}