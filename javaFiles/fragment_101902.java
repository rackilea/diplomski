public static void postOrderTrav(TreeNode node){
    if(node != null){
        postOrderTrav(node.getLeft());
        postOrderTrav(node.getRight());
        System.out.print(node.getVal() + " ");
        bw.write(node.getVal() + " ");
    }
}