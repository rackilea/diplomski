Button b = new Button("Add");
b.setOnAction(event -> {
    // Get the selected item
    TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();

    // If there is no selection or the root is selected do nothing
    if (selectedItem == null || selectedItem == rootNode)
        return;

    // Otherwise get the index of the Node from the children of its parent
    // and append the new item right after it
    int index = selectedItem.getParent().getChildren().indexOf(selectedItem);
    selectedItem.getParent().getChildren().add(index+1, new TreeItem<>("New Item"));
});