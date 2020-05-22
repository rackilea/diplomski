if (root == null) {
    BSTNode<T> node = new BSTNode<>(data);
    root = node;
} else {
    addRec(root, data);
}
size++;