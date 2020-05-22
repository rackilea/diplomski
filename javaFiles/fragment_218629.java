/**
 * Sort the table according to the configured sort policy
 * 
 * @param tree
 */
protected void sortTree(JFXTreeTableView<ScanModel> tree) {
    // Keep selected row and set it again after sort
    TreeItem<ScanModel> selectedRow = tree.getSelectionModel().getSelectedItem();
    tree.sort();
    tree.getSelectionModel().select(selectedRow);
}