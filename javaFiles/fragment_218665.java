public static int sumTree(TreeNode node){
        if(node == null)
            return 0;
        int old_value = node.value;
        node.value = sumTree(node.left) + sumTree(node.right);
        return node.value + old_value;
    }