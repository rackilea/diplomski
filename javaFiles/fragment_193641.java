private void datatypetableKeyPressed(java.awt.event.KeyEvent evt) {                                         
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                int col = datatypetable.getSelectedColumn();
                int row = datatypetable.getSelectedRow();
                int colCount = datatypetable.getColumnCount();
                int rowCount = datatypetable.getRowCount();
                col++;
                if (col >= colCount) {
                    col = 0;
                    row++;
                }
                if (row >= rowCount) {
                    row = 0;
                }
    //            datatypetable.getSelectionModel().setSelectionInterval(row, row);
    //            datatypetable.getColumnModel().getSelectionModel().setSelectionInterval(col, col);
    //            datatypetable.editCellAt(row, col);
                if (row == rowCount - 1) {
                    addRow();
                    datatypetable.scrollRectToVisible(datatypetable.getCellRect(rowCount, 0, true));
                }
            }

            if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                int col = datatypetable.getSelectedColumn();
                int row = datatypetable.getSelectedRow();
                int colCount = datatypetable.getColumnCount();
                int rowCount = datatypetable.getRowCount();
                col++;
                if (col >= colCount) {
                    col = 0;
                    row++;
                }
                if (row >= rowCount) {
                    row = 0;
                }
    //            datatypetable.getSelectionModel().setSelectionInterval(row, row);
    //            datatypetable.getColumnModel().getSelectionModel().setSelectionInterval(col, col);
    //            datatypetable.editCellAt(row, col);
                if (col == colCount - 1) {
                    addColumn();
                    int selectedRow = 0;
                    datatypetable.editCellAt(selectedRow, 0);
                    datatypetable.setSurrendersFocusOnKeystroke(true);
                    datatypetable.getEditorComponent().requestFocus();
                    datatypetable.scrollRectToVisible(datatypetable.getCellRect(colCount, 0, true));
                }
            }

        }  


    private void addRow() {
            DefaultTableModel model = (DefaultTableModel) datatypetable.getModel();

            if (model != null) {
                Vector v = new Vector(1);
    //            for (int j = 0; j <= datatypetable.getColumnCount(); j++) {
    //                v.add("");
    //            }
                v.add("");
                model.addRow(v);
            }
        }

        private void addColumn() {
            DefaultTableModel model = (DefaultTableModel) datatypetable.getModel();

            if (model != null) {
                Vector v = new Vector(1);
    //            for (int j = 0; j < datatypetable.getRowCount(); j++) {
    //                v.add("");
    //            }
                v.add("");
                model.addColumn(Character.toString((char) ('A' + datatypetable.getColumnCount())), v);
            }
        }