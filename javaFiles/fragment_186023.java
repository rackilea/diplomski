Node<T> buildBalancedTree(List<T> values) {
    if (values.isEmpty()) {
        return Node.NULL;
    } else {
        int middle = values.size() / 2;
        Node node = new Node(values.get(middle));
        node.setLeft(buildBalancedTree(values.subList(0, middle)));
        node.setRight(buildBalancedTree(values.subList(middle + 1, values.size())));
        return node;
    }
}