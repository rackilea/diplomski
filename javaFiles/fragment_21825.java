public static <T> ThreadedNode<T> thread(BinaryNode<T> root) {
    // We'll be keeping track of the "previous" node as we go, so use
    // a recursive helper method.  At first, there is no previous.
    return threadHelper(root, null);
}

private static <T> ThreadedNode<T> threadHelper(BinaryNode<T> n, ThreadedNode<T> previous) {

    // Create a new threaded node from the current root.  Note that the threaded nodes
    // are actually created in "preorder".  Assume the ThreadedNode constructor sets
    // the left, right, threadLeft, and threadRight fields to null.
    ThreadedNode<T> t = new ThreadedNode<T>(n.getData());

    // First go down the left side, if necessary.
    if (n.getLeft() != null) {
        // If there is a left child we have to descend.  Note that as we go down the
        // left side the previous doesn't change, until we start "backing up".
        t.left = threadHelper(n.getLeft(), previous);
        previous = t.left;
    } else {
        // If there is no left child, connect our left thread to the previous.
        t.threadLeft = previous;
    }

    // Now before we go down the right side, see if the previous
    // node (it will be in the left subtree) needs to point here.
    if (previous != null && previous.right == null) {
        previous.threadRight = t;
    }

    if (n.getRight() != null) {
        // If there is a right child we can descend the right.  As we go down we
        // update previous to the current node.  We do this just by passing the current
        // node as the second parameter.
        t.right = threadHelper(n.getRight(), t);
    } else {
        // No right child, no worries.  We'll hook up our thread-right pointer
        // later.
    }
    return t;
}