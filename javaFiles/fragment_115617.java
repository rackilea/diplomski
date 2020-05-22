public static List<Integer> getPath(Node node, List<Integer> path, int key) {
    if (node == null) {
        return null;
    } else if (node.data == key) {
        path.add(node.data);
        return path;
    }
    path.add(node.data);

    // path is unchanged if nothing is found in left children
    if (getPath(node.left, path, key) != null || getPath(node.right, path, key) != null) {
        // found in one branch or the other
        return path;
    }

    // not found in either branch, remove our data
    path.remove(path.size() - 1);
    return null;
}