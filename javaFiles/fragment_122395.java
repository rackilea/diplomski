private void addAll(UserNode n) {
    if (n == null) return;
    addAll(n.getLeft());
    usersInOrder.add(n.getValue());
    addAll(n.getRight());
}

private void beforeNum(int num, UserNode n){
    if (n == null) return;
    if (n.getValue() < num) {
        addAll(n.getLeft());
        usersInOrder.add(n.getValue());
        beforeNum(num, n.getRight());
    } else {
        beforeNum(num, n.getLeft());
    }
}