@FXML
private TableColumn<MyObject, SelectableInfo> myObjectChoicesTableColumn ;

myObjectChoicesTableColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSelectableInfo());

myObjectChoicesTableColumn.setCellFactory(col -> {
    ComboBox<SomeInfo> combo = new ComboBox<>();
    TableCell<MyObject, SelectableInfo> cell = new TableCell<MyObject, SelectableInfo>() {
        @Override
        protected void updateItem(SelectableInfo info, boolean empty) {
            super.updateItem(info, empty) ;
            if (empty) {
                setGraphic(null);
            } else {
                combo.setItems(info.getInfoList());
                combo.setValue(info.getSelectedInfo());
                setGraphic(combo);
            }
        }
    };
    combo.valueProperty().addListener((obs, oldValue, newValue) -> 
        cell.getItem().setSelectedInfo(newValue));
    return cell ;
});