private void populate() {
    root.getChildren().clear()
    for (int i = 1; i <= 10; i++) {
        String string = "String " + i;
        TreeItem<String> treeItem = new TreeItem<String>(string);
        root.getChildren().add(treeItem);

        // --------------Clear the selection -------------
        table.getSelectionModel().clearSelection();
        // -----------------------------------------------

    }
}