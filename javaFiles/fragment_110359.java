public Object[] toArray() {
    int size = 1;
    Customer3 curr = this;
    while (curr.next != null) {
        size++;
        curr = curr.next;
    }
    Object[] arr = new Object[size];
    arr[0] = this;
    for (int i = 1; i < size; i++) {
        arr[i] = ((Customer3)arr[i - 1]).next;
    }
    return arr;
}