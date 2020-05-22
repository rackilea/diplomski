public static void preorder(Node root) {
    if(root == null) return;

    root.printValue();
    preorder(root.getLeft());
    preorder(root.getRight());
    return;
}