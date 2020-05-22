class Node{
    Node pNode;
    int value;
    Node(Node pNode, int value){/* ... */}
    Node createLeftChild(){/* ... */}
    Node createRightChild(){/* ... */}
    boolean isPossible(int desiredOutput){
        return value <= desiredOutput;
    }
    /* ...... */
}