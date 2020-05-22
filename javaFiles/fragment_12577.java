table.getModel().addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            final int row = e.getFirstRow();
            final int column = e.getColumn();
            if (column == 4) {
                table.setValueAt("VALUE", row, column + 1);
            }
        }
    }
});