public class Node{

    public final Graph graph; //The graph this Node belongs to 
    private int id;
    private boolean visited;

    /** Constructs a Node with the given inputs. 
      * Also adds itself to g as part of construction */
    public Node(Graph g, int i, boolean v){
        graph = g;
        id = i;
        visited = v;
        graph.addNode(this);
    }

    public int getId(){
        return id;
    }

    public void setVisited(boolean v){
        visited = v;
    }

    //Getters for boolean fields usually follow the is<Field> pattern
    public boolean isVisited(){
        return visited;
    }

    /** Looks up the neighbors of this in the graph */
    public Set<Node> getNeighbors(){
        return graph.neighborsOf(this);
    }
}

public class Graph{

    private HashMap<Node, HashSet<Node>> graph;  //The actual graph. Maps a node -> its neighbors

    public Graph(){
        graph = new HashMap<Node, HashSet<Node>>();
    }

    /** Adds the node to this graph.
        If n is already in this graph, doesn't overwrite */
    public void addNode(Node n) throws IllegalArgumentException{
        if(n.graph != this) 
            throw new IllegalArgumentException(n + " belongs to " + n.graph ", not " + this);
        if(! graph.contains(n))
            graph.put(n, new HashSet<Node>());
    }

    /** Returns the neighbors of the given node. 
      * Returns null if the node isn't in this graph */
    public Set<Node> neighborsOf(Node n){
        if(! graph.contains(n))
            return null;

        return graph.get(n);
    }

    /** Connects source to sink. Also adds both to graph if they aren't there yet */
    public void makeConnection(Node source, Node sink){
        //Make sure source and sink belong to this graph first
        addNode(source);
        addNode(sink);

        //Make the connection by adding sink to source's associated hashset
        graph.get(source).add(sink);
    }
}