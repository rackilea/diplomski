public static int getDiameter(BinaryTreeNode root) {        
    if (root == null)
        return 0;

    int rootDiameter = getHeight(root.getLeft()) + getHeight(root.getRight()) + 1;
    int leftDiameter = getDiameter(root.getLeft());
    int rightDiameter = getDiameter(root.getRight());

    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
}

public static int getHeight(BinaryTreeNode root) {
    if (root == null)
        return 0;

    return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
}