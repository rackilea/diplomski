public static int sumTree(TreeNode root) {
    if (root == null) {
        return 0;
    }

    System.out.println("current value: " + root.getValue());
    int sum = (Integer) root.getValue();
    System.out.println(sum);
    sum += sumTree(root.getLeft());
    sum += sumTree(root.getRight());

    return sum;
}