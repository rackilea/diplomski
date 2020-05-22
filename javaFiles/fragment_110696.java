class Tree {
    Node<String> root;

    Node<?> findNode(String path);
    void addNode(Node<?> newNode);
    void validate(Node<?> node, int level);
    // All other tree operations go here

}