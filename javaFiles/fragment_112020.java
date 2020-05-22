treeView.setCellFactory(param -> {
    // creating cell from deafult factory
    TreeCell<String> treeCell = TextFieldTreeCell.forTreeView().call(param);
    // setting handlers
    treeCell.setOnDragDetected(this::onDragDetected);
    treeCell.setOnDragOver(this::onDragOver);
    treeCell.setOnDragDropped(this::onDragDropped);
    return treeCell;
});