/**
 * Appends to the specified list all keys from {@code node} to the {@link Node} containing the
 * specified {@code key}. If the key is not found in the specified node's children, the list is
 * guaranteed to be unchanged. If the key is found among the children, then the specified list
 * will contain the new elements (in addition to the old ones).
 * 
 * @param node
 *            the node to start at
 * @param path
 *            the current path to append data to
 * @param key
 *            the key to stop at
 * @return true if the key was found among the specified node's children, false otherwise
 */
public static boolean getPath(Node node, List<Integer> path, int key) {
    if (node == null) {
        // leaf reached, and the key was not found
        return false;
    }

    // add data to the path
    path.add(node.data);

    // the OR is lazy here, so we treat everything in the given order
    // if getPath failed on the left children, path is unchanged and used for right children
    if (node.data == key || getPath(node.left, path, key) || getPath(node.right, path, key)) {
        // the key is found in the current node, its left children, or its right children
        return true;
    }

    // not found in either branch, remove our data
    path.remove(path.size() - 1);
    return false;
}