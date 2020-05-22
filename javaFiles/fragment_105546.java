static int getHeight(Tree tree) {
    if (tree == null) {
        return 0;
    }

    return 1 + max(getHeight(tree.left, tree.right));
}