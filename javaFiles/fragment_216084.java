public void insertAndSort(E element) {
    if (isEmpty()) {
        add(element);
        return;
    }
    int len = size();
    int pos = 0;
    while (pos < len && element.compareTo(get(pos)) > 0) {
        pos++;
    }
    add(pos, element);
}