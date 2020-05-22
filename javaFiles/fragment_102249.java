public boolean hasNext() {

    return false;
}

public void addItems(Queue1<? extends E> q) {

    while (q.hasNext()) list.addLast(q.dequeue());
}