public void print() {
    if (head == null) System.out.println("()");

    NodeFN tmp = head;

    while(tmp != null) {
        System.out.println(tmp.getData() + " ");
        tmp = tmp.getNext();
    }
}