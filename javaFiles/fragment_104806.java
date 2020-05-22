listView.setCellFactory(lv -> new ListCell<File>() {
    @Override
    protected void updateItem(File file, boolean empty) {
        super.updateItem(file, empty);
        setText(file == null ? null : file.getName());
    }
});