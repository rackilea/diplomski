public int search(T item) {
    Node x = first;
    int c = size() - 1;
    while(x != null) {
        if(x.item.equals(item)) {
            return c;
        }
        x = x.next;
        c--;
    }
    return -1;
}