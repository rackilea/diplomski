public static void sumofChild(Node root) {
    if (root == null) return;
    sumofChild(root.getLeft());
    sumofChild(root.getRight());
    if (root.getLeft() != null) {
        int sum = root.getData() + root.getLeft().getData();
        root.setData(sum);
    }
}