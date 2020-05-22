public void insertNodeBeAfter(E nVal, E curVal) {
    Node<E> newNode = new Node<E>(nVal);

    Node<E> curr = head;

    // scan until locate node or come to end of list
    while (curr != null) {
        // have a match 
        // Replaced == with .equals
        if (curr.getNodeValue().equals(curVal)) {
            // insert node
            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
            break;
        } else {
            curr = curr.getNext();
        }
    }
}