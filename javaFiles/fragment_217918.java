Button b = new Button("Add");
b.setOnAction(event -> {
    // If there is no selection or the root is selected do nothing
    if (current == null || current == rootNode)
        return;

    // Otherwise get the index of the Node from the children of its parent
    // and append the new item right after it
    int index = current.getParent().getChildren().indexOf(current);
    current.getParent().getChildren().add(index+1, new TreeItem<>("New Item"));
});