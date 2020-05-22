if (isEmpty()) { return null; }

Node<E> curr = header;
Node<E> min  = curr;
E minElement = curr.getElement();

while (curr != null) {
    if (curr.getElement() != null) {
        if (minElement.compareTo(curr.getElement()) > 0) {
            min = curr;
            minElement = curr.getElement();
        }
    }
    curr = curr.getNext();
}
return minElement;