public void displayTreeView(String inputDirectoryLocation) {
    // Creates the root item.
    CheckBoxTreeItem<String> rootItem = new CheckBoxTreeItem<>(inputDirectoryLocation);

    // Hides the root item of the tree view.
    treeView.setShowRoot(false);

    // Creates the cell factory.
    treeView.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

    // Get a list of files.
    File fileInputDirectoryLocation = new File(inputDirectoryLocation);
    File fileList[] = fileInputDirectoryLocation.listFiles();

    // create tree
    for (File file : fileList) {
        createTree(file, rootItem);
    }

    treeView.setRoot(rootItem);
}