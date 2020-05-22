public void inFix(TreeNode root, List<Integer> inFixRep) {
    if (root != null) {
        inFix(root.left, inFixRep);
        inFixRep.add(root.data);
        inFix(root.right, inFixRep);
    }
}