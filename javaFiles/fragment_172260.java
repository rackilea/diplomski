TreeView treeView = ... ; // initialize this
TreeItem treeItem = ... ; // initialize this, too
MultipleSelectionModel msm = treeView.getSelectionModel();

// This line is the not-so-clearly documented magic.
int row = treeView.getRow( treeItem );

// Now the row can be selected.
msm.select( row );