private static void cloneRoot(DefaultMutableTreeNode updatableRoot) {
    updatableRoot.removeAllChildren();
    for (int i = 0; i < root.getChildCount() / 2; i++) {
        updatableRoot.add((javax.swing.tree.MutableTreeNode) root.getChildAt(i));
    }
}