public int getLength(LinkedList list) {
    if (list == null) {
        return 0;
    } else {
        return 1 + getLength(list.getTail());
    }
}