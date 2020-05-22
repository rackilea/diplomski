protected void insertNodeAfter(Node currentNode, Node newNode) {
    Node displacedNode = currentNode.getNext();
    currentNode.setNext(newNode);
    newNode.setNext(displacedNode)
    displacedNode.setPrev(newNode);
    newNode.setPrev(currentNode);
}