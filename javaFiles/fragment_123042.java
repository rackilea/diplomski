optionsCol.setCellFactory( col -> new TableCell<User, Options>() {
    private TreeView<...> treeView ;
    {
        treeView = new TreeView<>(...);
        // configure tree view, etc
    }
    @Override
    public void updateItem(Options options, boolean empty) {
        super.updateItem(options, empty) ;
        if (empty) {
            setGraphic(null);
        } else {
            // configure treeView with data from options, etc
            setGraphic(treeView);
        }
    }
});