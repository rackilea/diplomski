public static void printRandom(TreeNode n, int randomNum) {
    int leftSize = n.left == null ? 0 : n.left.size;
    if (randomNum == leftSize + 1)
        System.out.println(n.data);
    else if (randomNum > leftSize + 1)
        printRandom(n.right, randomNum - (leftSize + 1));
    else
        printRandom(n.left, randomNum);
}