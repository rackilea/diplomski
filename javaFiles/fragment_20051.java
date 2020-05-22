Node n = root;
if (n != null) {
    visit(n);
    preOrder(n.left);
    preOrder(n.right);
}