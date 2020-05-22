public ListElement<Integer> find(ListElement<Integer> head, int data) {
    for (ListElement<Integer> current = head;
           current != null;
           current = current.next()) {
        if (current.value == data) {
            return current;
        }
    }
    // No entry found
    return null;
}