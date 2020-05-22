public int closetValue(TreeNode root, double target){
    return dfs(root, target, root.val);
}

private int dfs(TreeNode root, double target, int minVal){
    if(root == null) return minVal;
    if(Math.abs(root.val - target) < Math.abs(minVal - target)){
        minVal = root.val;
    }
    minVal = dfs(root.left, target, minVal);
    minVal = dfs(root.right, target, minVal);
    return minVal;
}