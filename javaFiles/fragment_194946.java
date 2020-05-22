if (node.left == null && node.right == null) {
    print(list);
    // Note no return statement
} else {
    paths(node.left, list);
    paths(node.right, list);
}
list.removeLast();