public int dfs(TreeNode root, int mn, int mx) {

    // this is the base case, at some point mn was encountered and mx was encountered
    // on the path to this node, this is the maximum possible difference along that path
    if (root == null) return mx - mn;

    // on our current path through the tree, update the max / min value we have encountered
    mx = Math.max(mx, root.val);
    mn = Math.min(mn, root.val);

    // the mn and mx at this point are only reflective of this node and it's ancestors
    // integers are immutable so a function call down the line won't change the 
    // mx and mn here, but rather create a new mx and mn at that node
    // we pass the updated mx and mn to the node's children, exploring paths
    // down the tree

    return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
}