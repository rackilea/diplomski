JTable table = new JTable(model) {
    public Component prepareRenderer(TableCellRenderer renderer, int Index_row, int Index_col) {
        // get the current row
        Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
        // even index, not selected
        if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
            comp.setBackground(Color.lightGray);
        } else {
            comp.setBackground(Color.white);
        }
        return comp;
    }
};