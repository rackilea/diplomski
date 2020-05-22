public void inOrderTraverseTree (Node focusNode, PrintStream printStream) {
    if (focusNode != null){
        inOrderTraverseTree(focusNode.leftChild, printStream);
        printStream.println(focusNode);
        inOrderTraverseTree(focusNode.rightChild, printStream);
    }//end if
}//end inOrderTraverseTree