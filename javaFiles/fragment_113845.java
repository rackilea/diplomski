final ObservableList<Integer> values = FXCollections.observableArrayList(0, 1);

column.setCellFactory((TableColumn<Model, Integer> p) -> {
    ComboBoxTableCell<Model, Integer> cell = new ComboBoxTableCell<Model, Integer>(values) {
        @Override
        protected void updateItem(Integer item, boolean empty) {
            ...
        }
    };
    return cell;
});