final JTable table = new JTable();
TableModelListener l = new TableModelListener() {

    @Override
    public void tableChanged(TableModelEvent e) {
        if (TableUtilities.isInsert(e)) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    int viewRow = table.convertRowIndexToView(e.getFirstRow());
                    table.scrollRectToVisible(table.getCellRect(viewRow, 0, true));    
                }
            });
        }
    }
};
table.getModel().addTableModelListener(l);