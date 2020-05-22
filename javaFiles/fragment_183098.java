// Remove the node containing item nVal
public void remove(E curVal) {
    Node<E> curr = head;
    Node<E> prev = null;


    // scan until locate node or come to end of list
    while (curr != null) {
        // have a match 
        if (curr.getNodeValue().equals(curVal)) {

            if (prev == null) {  // curr is first node: just start to next
                head = curr.getNext();
            }
            else {   // make prev point to next
                prev.setNext(curr.getNext());
            }
            break;
        } else {
            // advanced curr and prev
            prev = curr;
            curr = curr.getNext();
        }
    }
}