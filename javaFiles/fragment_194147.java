public Node insert(Node current, int data) {
    if (current == null) {
        return createNode(data);
    } else if (data < current.data) {
        //RECURSIVE CALL HERE WITHOUT USE OF A RETURN STATEMENT
        current.left = insert(current.left, data);
    } else if (data > current.data) {
        current.right = insert(current.right, data);
    }

    return current;
}