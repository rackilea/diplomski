public Node parent(String parentName, Node root) {
    if (root != null) {
        if (root.getName().equals(parentName)) {
            return root;
        } else {
            Node found = parent(parentName, root.getLeftChild());
            if (found == null) {
                found = parent(parentName, root.getRightChild());
            }
            return found;
        }
    } else {
        return null;
    }
}