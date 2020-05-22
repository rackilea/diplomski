// Just row selection
tableView.getSelectionModel().setCellSelectionEnabled(false);

tableView.getFocusModel().focusedCellProperty().addListener(new ChangeListener<TablePosition>() {

    @Override
    public void changed(ObservableValue<? extends TablePosition> arg0, TablePosition arg1, TablePosition arg2) {
        // Get the data from the desired cell (tableview displays Data objects)
        Data item = tableView.getItems().get(arg2.getRow());
        String data = (String) col2.getCellObservableValue(item).getValue();
        System.out.println(data);
    }
});