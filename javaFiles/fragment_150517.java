salutation.setCellFactory((tableColumn)->new TableCell() {

    @Override
    protected void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);
        setText(item == null ? "" : item.toString());
    }

});