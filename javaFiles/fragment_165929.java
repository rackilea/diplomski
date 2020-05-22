TableModel model = table.getModel();
model.addTableModelListener(new TableModelListener() {
    @Override
    public void tableChanged(TableModelEvent e) {
        ... e.firstRow, e.lastRow
    }
});