public boolean contains(E value) {
    Node current = root;

    while (current != null) {
        int comparison = value.compareTo(current.value);
        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            current = current.left;
        } else { //comparison > 0
            current = current.right;
        }
    }

    return false;
}