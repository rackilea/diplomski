private void printInOrderRec(Node root) {
    sb.append("(");
    if (root != null) {
        printInOrderRec(root.left);
        sb.append(root.val);
        printInOrderRec(root.right);
    }
    sb.append(")");
}