public void remove(int i) {
    if (i==0) {
        head = head.getNext();
        decreaseListSize();
        return;
    }

    if (i < 1 || i > getListSize()) {
        return;
    }

    Element current = head;
    if (head != null) {
        for (int e = 1; e < i; e++) {
            if (current.getNext() == null)
                return ;
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        decreaseListSize();
    }
}