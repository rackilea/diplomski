private void tableKeyEvent(KeyEvent e) {
    TableColumn refocusColumn = null;

    if (e.getCode() == KeyCode.F1) {
        refocusColumn = table.getFocusModel().getFocusedCell().getTableColumn();
        table.getSortOrder().setAll(idColumn);
    }
    if (e.getCode() == KeyCode.F2) {
        refocusColumn = table.getFocusModel().getFocusedCell().getTableColumn();
        table.getSortOrder().setAll(firstNameColumn);
    }
    if (e.getCode() == KeyCode.F3) {
        table.getSortOrder().setAll(lastNameColumn);

        TablePosition selectedPosition = table.getSelectionModel().getSelectedCells().get(0);
        int selectedRow = selectedPosition.getRow();
        TableColumn selectedColumn = selectedPosition.getTableColumn();

        table.getSelectionModel().select(selectedRow, selectedColumn);
    }
    if (refocusColumn != null) {
        // print focused column for "debugging"
        System.out.println(table.getFocusModel().getFocusedCell().getTableColumn());

        // focus previously focused column again to fix issue
        table.getFocusModel().focus(table.getSelectionModel().getSelectedIndex(), refocusColumn);
    }
}