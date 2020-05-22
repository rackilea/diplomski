public LinkedList() {
    first = new Node<T>(null);  // no data in first
    last = new Node<T>(null);   // no data in last
    first.setNext(last);
    last.setPrevious(first);
}