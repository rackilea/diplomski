public void visitNode(Node node) {
    if(node.left != null) {
        visitNode(node.left);
    }
    if(node.right != null) {
        visitNode(node.right);
    }
    if(node.left == null && node.right == null) {
        //OMG! leaf!
    }
}