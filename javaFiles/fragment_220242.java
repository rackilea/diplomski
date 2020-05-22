propertyBox.setCellFactory(param -> {
    final ListCell<String> cell = new ListCell<String>() {
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty)
                setText(item);
        }
    };
    cell.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
        propertyBox.setValue(null);
        propertyBox.getSelectionModel().select(cell.getItem());

        e.consume();
    });
    return cell;
});