cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            int selectedRow = table.getSelectedRow();
            int selectedColumn = table.getSelectedColumn();
            if (selectedRow >= 0) {
                if (table.convertColumnIndexToModel(selectedColumn) == 0) {
                    Boolean valorCol = (Boolean) table.getValueAt(selectedRow,selectedColumn);
                    if (valorCol == true) {
                        table.setValueAt(Boolean.FALSE,selectedRow,selectedColumn);
                    }
                    else {
                        table.setValueAt(Boolean.TRUE,selectedRow,selectedColumn);
                    }
                }
            }
        }
        table.clearSelection();
    }
});