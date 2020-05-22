private void insert(int number, Node node) {
    if (number < node.value && node.left != null) {
        node = node.left;
        insert(number, node);
        return;
    } 
    else {
        if (node.left == null)
            node.left = new Node(null, null, number);
        return;
    }

    if (number > node.value && node.right != null) {
        node = node.right;
        insert(number, node);
        return;
    }
    else {
        if (node.right == null)
            node.right = new Node(null, null, number);
        return;
    }
}