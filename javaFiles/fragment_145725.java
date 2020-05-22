order.setCellFactory(lv -> {
    ListCell<String> cell = new ListCell<String>() {
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(item);
        }
    };
    cell.setOnMouseClicked(event -> {
        String item = cell.getItem();
        if (item != null) {
            orderOvList.remove(item);

            // ensure nothing selected after removal:
            order.getSelectionModel().clearSelection();
        }
    });
    return cell ;
});