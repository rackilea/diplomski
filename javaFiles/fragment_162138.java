public boolean remove(String data){
    Node current = head.getNext();
    Node previous = null;
    while (current != null) {
        String dataOld = current.getData();
        if ((dataOld == null && data == null) || (dataOld != null && dataOld.equals(data))) {
            Node afterRemoved = current.getNext();
            if (previous == null) {
                head.setNext(afterRemoved);
            } else {
                previous.setNext(afterRemoved);
            }
            if (afterRemoved.getNext() == null) {
                last = afterRemoved;
            }
            size--;
            return true;
        } else {
            previous = current;
            current = current.getNext();
        }
    }
    return false;
}