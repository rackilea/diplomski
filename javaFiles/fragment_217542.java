/** Return tree height - my own method */
    public int treeHeight(TreeNode <E> node) {
        // height of empty tree = ZERO
        if (node == null)
            return 0;

        int leftHeight = treeHeight(node.left);
        int rightHeight = treeHeight(node.right);

        if (leftHeight > rightHeight)
            return leftHeight+1; // bug was here: you should return the height of the child + 1 (yourself)
        else
            return rightHeight+1; // and here
    }