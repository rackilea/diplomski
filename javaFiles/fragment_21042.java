ListView<File> listView = ...
listView.setCellFactory(lv -> new ListCell<File>() {

    @Override
    protected void updateItem(File item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            // restore empty look of the cell
            setText("");
        } else {
            // set cell contents based on item
            setText(item.getName());
        }
    } 

});