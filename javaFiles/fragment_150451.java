public void reverse() {
    Node<Type> orig_head = head;
    Node<Type> rememberMe = head.getNextNode();

    while(rememberMe != null) {
        Node<Type> temp = head;
        head = rememberMe;
        rememberMe = head.getNextNode();
        head.setNextNode(temp);
    }
    orig_head.setNextNode(null);
}