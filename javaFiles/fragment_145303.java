public boolean addEdge(Node node1, Node node2) {
        return false;
    }

    Graph<Integer> g = new Graph<Integer>();
    Graph<Integer>.Node n0 = g.new Node(0);// As T happens to be integer you can use inside node class also.

    public class Node {
        T t;
        Node(T t) {
        }
    }