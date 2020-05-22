this.fileTreeView.setCellFactory(new Callback<TreeView<FileShort>,TreeCell<FileShort>>(){
    @Override
    public TreeCell<FileShort> call(TreeView<FileShort> p) {
        TreeCell<FileShort> cell = new TreeCell<FileShort>() {
            @Override
            protected void updateItem(FileShort file, boolean empty) {
                super.updateItem(file, empty);
                if (empty) {
                    setText(null);
                } else {
                    // maybe use a more appropriate string for display here
                    // e.g. if you were using a regular java.io.File you would
                    // likely want file.getName()
                    setText(file.toString());
                }
            }
        };
        ContextMenu cm = createContextMenu(cell);
        cell.setContextMenu(cm);
        return cell;
    }
});

private ContextMenu createContextMenu(TreeCell<FileShort> cell) {
    ContextMenu cm = new ContextMenu();
    MenuItem openItem = new MenuItem("Open File");
    openItem.setOnAction(event -> {
        FileShort file = cell.getItem();
        if (file != null) {
            // open the file...
        }
    });
    cm.getItems().add(openItem);
    // other menu items...
    return cm ;
}