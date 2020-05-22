private Node addRecursive(Node current, int value) {
    if (current == null) {
        return new Node(value);
    }

    System.out.println("current is " + current.value);

    if (value < current.value) {
        current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
        current.right = addRecursive(current.right, value);
    } else {
        // value already exists
        return current;
    }

    return current;
}