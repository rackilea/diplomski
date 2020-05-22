import java.util.HashSet;
import java.util.Set;

public class Node<T> {
    private final T data; // The data that you want to store in this node.
    private final Set<Node> adjacentNodes = new HashSet<>();

    // Constructor
    public Node(T data) {
        this.data = data;
    }

    // Getters

    /*
     * Returns the data stored in this node.
     * */
    public T getData() {
        return data;
    }

    /*
     * Returns a set of the adjacent nodes of this node.
     * */
    public Set<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    // Setters

    /*
     * Attempts to add node to the set of adjacent nodes of this node. If it was not previously added, it is added, and
     * true is returned. If it was previously added, it returns false.
     * */
    public boolean addAdjacent(Node node) {
        return adjacentNodes.add(node);
    }
}