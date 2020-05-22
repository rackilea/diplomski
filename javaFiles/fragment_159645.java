this.selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
    @Override
    public void onSelectionChange(SelectionChangeEvent event) {
         T selectedObj = selectionModel.getSelectedObject();
         TreeNode rootNode = cellTree.getRootTreeNode();
         openTree(rootNode,T);
    }
});


private void openTree(rootNode node,T object) {
    for (int i = 0; i < node.getChildCount(); i++) {
        if (!node.isChildLeaf(i)) {
            find(node.setChildOpen(i, true));
            if (node.getValue().equals(T)) 
                return;
        }
    }
}