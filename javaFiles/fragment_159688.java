cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            int selectedRow = table.getSelectedRow();
            int selectedColumn = table.getSelectedColumn();
            if (selectedRow >= 0) {
                int rowModelId = table.convertRowIndexToModel(selectedRow);
                int colModelId = table.convertColumnIndexToModel(selectedColumn);
                if (colModelId == 0) {
                    Boolean valorCol= (Boolean) documents[rowModelId][0];
                    if (valorCol== true) {
                        documents[rowModelId][0] = false;
                    }
                    else {
                        documents[rowModelId][0] = true;
                    }
                    dataModel.fireTableCellUpdated(rowModelId,0);
                }
            }
        }
        table.clearSelection();
    }
});