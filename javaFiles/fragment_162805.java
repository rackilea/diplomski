// First, move the item up in the list.
listModel.moveUp(list.getSelectedIndex());

// Now, set the selection index to keep the same item selected.
//
// If you use the default list selection interval, setting the index to -1
// will do nothing (so it's okay, we don't need error checking here).
list.setSelectedIndex(list.getSelectedIndex() - 1);