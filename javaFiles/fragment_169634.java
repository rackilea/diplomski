// Enable cell selection
tableView.getSelectionModel().setCellSelectionEnabled(true);

// On focused property change
tableView.getFocusModel().focusedCellProperty().addListener(new ChangeListener<TablePosition>() {

    @Override
    public void changed(ObservableValue<? extends TablePosition> arg0, TablePosition arg1, TablePosition arg2) {
        // Select TableColumn "col2" in the same row
        tableView.getSelectionModel().select(arg2.getRow(), col2);

    }
});