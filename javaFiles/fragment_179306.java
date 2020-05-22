import java.util.Hashmap;
import java.util.ArrayList;

class Node {
    String label;
    ArrayList<Node> adjacencyList;
}

HashMap<String, Node> graph = new HashMap<String, Node>();