public void traverse(TreeNode node){
    if(node == null){
        return;
    }else {
        // display values to the left of current node
        traverse(node.left);
        // display current node
        System.out.println(node.value);
        // display values to the right of current node
        traverse(node.right);
    }
}