public class Node {
    private int payload;
    private Node next;
    private Node prev;

    public Node(int payload) {
        this.payload = payload;
        prev = null;
        next = null;
    }

    public Node getNextNode() {
        return next;
    }

    public Node getPrevNode() {
        return prev;
    }

    public void setNextNode(Node n) {
        next = n;
    }

    public void setPrevNode(Node n) {
        prev = n;
    }

    public int getPayload() {
        return payload;
    }

}