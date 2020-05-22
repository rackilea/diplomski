boolean isValid(Node node) {
    if (node.left != null && (cur.data < node.left.data || !isValid(node.left)))
        return false;
    else if (node.right != null && (cur.data > node.right.data || !isValid(node.right)))
        return false;
    else
        return true;
}