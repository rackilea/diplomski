myObjectChoicesTableColumn.setCellFactory(col -> {

    ComboBox<SomeInfo> combo ;

    TableCell<MyObject, List<SomeInfo>> cell = new TableCell<MyObject, List<SomeInfo>>() {
        @Override
        protected void updateItem(List<SomeInfo> info, boolean empty) {
            super.updateItem(info, empty);
            if (empty) {
                setGraphic(null);
            } else {
                MyObject rowItem = myObjectTableView.getItems().get(getIndex());
                combo.getItems().setAll(info);
                combo.setValue(rowItem.getSelectedInfo());
                setGraphic(combo);
            }
        }
    };

    combo.valueProperty().addListener((obs, oldValue, newValue) -> 
        myObjectTableView.getItems().get(cell.getIndex()).setSelectedInfo(newValue));

    return cell ;
}