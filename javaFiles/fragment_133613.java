/**
 * Get the tail of a tree.
 * @return the tree without the smallest value.
 */
public BinaryTree tail() {
    if (left != null) {
        return new BinaryTree(value, left.tail(), right);
    }
    return right; // Could make a deep copy.
}