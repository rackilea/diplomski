Node delete(int value, Node node) {
    if (value<node.value) node.left = delete(value, node.left);
    else if (value> node.value)
        node.right = delete(value, node.right);
    ...I'll leave the rest as an exercise...
    return node;
}