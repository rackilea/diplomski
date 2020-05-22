class Tree {
    private volatile Node node;
    public void update() {
        node = new Node(...);
    }
    public Node get() {
        return node;
    }
}