public class NodesToProcess {

    private Node oldNode;
    private NewNode newNode;
    private List<Node> toRemove;
    public NodesToProcess(Node oldNode, NewNode newNode, List<Node> toRemove) {
        this.oldNode = oldNode;
        this.newNode = newNode;
        this.toRemove = toRemove;
    }

    public Node getOldNode() {
        return oldNode;
    }

    public Node getNewNode() {
        return newNode.getNewNode();
    }

    public List<Node> getToRemove() {
        return toRemove;
    }

}