public void editLeft(int index, Item item) {
    Node node = right;
    while (node != null && index > 0) {
        node = node.prev;
        index--;
    }
    if (node != null) {
        node.item = item;
    } else {
        throw new IllegalRangeException("Attempt to edit value with illegal index");
    }
}