//Where the tree is initialized:
tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

//Listen for when the selection changes.
tree.addTreeSelectionListener(this);

public void valueChanged(TreeSelectionEvent e) {
    //Returns the last path element of the selection.
    //This method is useful only when the selection model allows a single selection.
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

    if (node == null)
    //Nothing is selected.  
    return;

    Object nodeInfo = node.getUserObject();

    if (node.isLeaf()) {
        BookInfo book = (BookInfo) nodeInfo;
        displayURL(book.bookURL);
    } else {
        displayURL(helpURL);
    }

}