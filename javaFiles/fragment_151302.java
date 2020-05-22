public void inOrderPrint(Node node){

    if (node.left != null) {
        inOrderPrint(node.left);
    }

    System.out.println(node.value);

    if (node.right != null) {
        inOrderPrint(node.right);
    }
}