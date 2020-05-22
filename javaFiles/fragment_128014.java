public T getEntry(int givenPosition) {
T result = null;

if ((givenPosition >= 0) && (givenPosition < length)) {
    Node currentNode = firstNode;
    for (int i = 0; i < givenPosition; ++i) {
        currentNode = currentNode.next;     // advance currentNode to next node
    }
    result = currentNode.data;  // currentNode is pointing to the node at givenPosition
}
return result;
}