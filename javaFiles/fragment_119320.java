package il.ac.oranim.alg2016;

 import edu.princeton.cs.algs4.*; 

 public class MST_12
{   
private int weight; // weight of the tree
private Edge[] mstEdges; // MST edges

private boolean[] marked;// MST vertices
private Queue<Edge> queueWeight1; 
private Queue<Edge> queueWeight2; 

   public MST_12(EdgeWeightedGraph G, int s)  throws      IndexOutOfBoundsException, DisconnectedGraphException, WrongWeightException 
{
    // check that the starting vertex is in the range 0,1,...,G.V()
    if (s < 0 || s >= G.V()) {
        throw new IndexOutOfBoundsException();
    }
    // check that the input graph is connected otherwise there is no (minimum) spanning tree
    if (isConnected(G) == false) {
        throw new DisconnectedGraphException();
    }
    // check that all the weights are 1 or 2
    for (Edge e : G.edges()) {
        if (e.weight() != 1 && e.weight() != 2) {
            throw new WrongWeightException();
        }
    }

    this.weight = 0; // make sure you update this value

    // replace -->

    queueWeight1 = new Queue<Edge>();
    queueWeight2 = new Queue<Edge>();
    mstEdges=new Edge[G.V()];
    marked=new boolean[G.V()];  

     for (int v = 0; v < G.V(); v++)      // run from each vertex to find
            if (!marked[v]) KPrim(G,v);// minimum spanning forest
}

  private void KPrim ( EdgeWeightedGraph G, int s)
    {
         visit(G,s);
         while (!queueWeight1.isEmpty()||!queueWeight2.isEmpty()){   
              Edge e=null;
              if (!queueWeight1.isEmpty())
                 { e=queueWeight1.dequeue();}
              else if (!queueWeight2.isEmpty()){e=queueWeight2.dequeue();}
              int v=e.either(), w=e.other(v);
              assert marked [v]||marked [w];
              if(marked[v]&&marked[w]) continue;
              mstEdges[s]=e;
              weight+=e.weight();
              if(!marked[v]) visit(G,v);// v becomes part of tree
              if(!marked[w]) visit(G,w);// w becomes part of a tree
         }          
    }

//add all edges e incident to v onto queue if the other endpoint has not yet been scanned
    private void visit (EdgeWeightedGraph G, int v)
    {
    marked[v]=true;// add v to T
    for (Edge e : G.adj(v))// for each edge e=v-w, add to queueWeight if w not already in T  
    { 
       if(!marked[e.other(v)])  {       
            if (e.weight()==1.0) {queueWeight1.enqueue(e);mstEdges[v]=e;}//add the smallest edge weight to the mst weight
            else {queueWeight2.enqueue(e);mstEdges[v]=e;}}}

    }

    // <-- replace


// returns the weight of the tree
public int weight() {
    return this.weight;
}

// checks whether a graph is connected
private static boolean isConnected(EdgeWeightedGraph G) {
    // create a graph of class Graph with the same edges (weights)
    Graph g = new Graph(G.V());
    for (Edge e : G.edges()) {
        int v = e.either();
        g.addEdge(v, e.other(v));
    }
    // compute the connected components of the graph
    CC cc = new CC(g);

    // return true iff there is only one connected component
    return cc.count() == 1;
}

/**
 * Returns the edges in a minimum spanning tree as
 *    an iterable of edges
 */
public Iterable<Edge> edges() {
    Queue<Edge> edges = new Queue<Edge>();
    for (int i = 0; i < this.mstEdges.length; i++) {
        Edge e = this.mstEdges[i];
        int v = e.either();
        edges.enqueue(new Edge(v, e.other(v), e.weight()));
    }
    return edges;
}

/**
 * test the computing of an MST of a graph with weights 1 and 2 only
 * the first argument is the name of the file that contains the graph (graph1.txt, graph2.txt, or graph3.txt)
 * you can define this argument in Run.. --> (x)=Arguments
 */
public static void main(String[] args) {
    In in = new In(args[0]);
    EdgeWeightedGraph G = new EdgeWeightedGraph(in);

    PrimMST primMST = new PrimMST(G);       
    MST_12 mst12 = null;
    try {
        mst12 = new MST_12(G,0);
    }
    catch (DisconnectedGraphException e) {
        System.err.println("the input graph is not connected and hence has no (minimum) spanning tree");
    }
    catch (WrongWeightException e) {
        System.err.println("not all weights in the input graph are 1 or 2");            
    }

    System.out.println("Prim's MST weight = " + primMST.weight());
    System.out.println("My MST's weight = " + mst12.weight());
}
}