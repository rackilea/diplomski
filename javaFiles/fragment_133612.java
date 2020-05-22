public BinaryTree merge(BinaryTree other) {
    if (other != null) {
        return insert(other.head()).merge(other.tail());
    }
    return this;
}