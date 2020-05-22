public void inOrderTraverseTree (Node focusNode, LinkedList<Node> output) {
    if (focusNode != null){
        inOrderTraverseTree(focusNode.leftChild, output);
        output.add(focusNode);
        inOrderTraverseTree(focusNode.rightChild, output);
    }//end if
}//end inOrderTraverseTree