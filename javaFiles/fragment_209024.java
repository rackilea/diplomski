public E top() {
    if (head == null)
        return null;
    Node<E> tempNode = head;
    while(tempNode.getmNextNode()!=null) {
        tempNode = tempNode.getmNextNode();
    }
    return tempNode.getmElement();
}