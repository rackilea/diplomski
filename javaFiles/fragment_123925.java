private int getSingleParents(TreeNode t) {
    int count = 0;
    if(t != null) {
        if(t.getLeft() == null && t.getRight() != null)
            count++;
        else if(t.getLeft() != null & t.getRight() == null)
            count++;
        count += getSingleParents(t.getLeft());
        count += getSingleParents(t.getRight());
    }
    return count;
}