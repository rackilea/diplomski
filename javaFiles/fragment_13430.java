public void bubbleSort() {
    boolean done = false;
    while (!done) {
        Node cur = head;
        done = true;
        while(cur != tail) {
            if (cur.getNext().getCount()>cur.getCount()) {
                swap(cur.getNext(),cur);
                done=false;
            }
            cur = cur.getNext();
        }
    }
}