public void add(int i) {
    if (root == null) {
        root = new BTNode(i);
    } else {
        root.add(i);
    }
}