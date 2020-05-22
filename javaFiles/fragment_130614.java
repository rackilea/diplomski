document.traverse(new NodeVisitor() {
    public void head(Node node, int depth) {
        System.out.println("Entering tag: " + node.nodeName());
    }
    public void tail(Node node, int depth) {
        System.out.println("Exiting tag: " + node.nodeName());
    }
});