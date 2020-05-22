if (number > node.value && node.right != null) {
    node = node.right;
    insert(number, node);
} else {
    if (node.right == null)
        node.right = new Node(null, null, number);
}