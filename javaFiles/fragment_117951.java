private void getDeepCopy() {
       final JTree initialTree = copyBuilder.cloneTree();
       final TreeModel model = initialTree.getModel();
       clonedRoot = (DefaultMutableTreeNode) model.getRoot();
       if (clonedTree != null) {
          clonedTree.setModel(model);
       } else {
         clonedTree = initialTree;
       }
    }