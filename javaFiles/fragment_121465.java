// removes the largest node in the binary tree with root at t.
// returns the new root.
public BinaryNode<AnyType> removeMax(BinaryNode<AnyType> t)
{
    if (t == null) return null;
    if (t.right == null) {
        // the node passed in is the largest.
        return t.left;
    }

    // traverse the right branch to the last node,
    // keeping track of the previous node so you can correctly set its
    // right pointer to null.
    BinaryNode<AnyType> parent = t;
    BinaryNode<AnyType> child = parent.right;
    while (child.right != null) {
        parent = child;
        child = child.right;
    }
    parent.right = null;
    return t;
}