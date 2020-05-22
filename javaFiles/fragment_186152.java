private int calculateWeight(Object startNode, HashMap<Node, Boolean> visitedNodes, HashMap<Edge, Boolean> visitedEdges) {
    int w = 0;
    if (!visitedNodes.get(startNode)) {
        // Don't know if this method (getEdeges) exists, but if you could implement 
        // a way to get all the edges that go out from a node, then paste the code  here 
        //
        // Get the edges from the node
        Collection edges = startNode.getEdges();

        for (Object edge : edges) { 
            // If the edge haven't been visited, then add its weight to w
            if (!visitedEdges.get(edge)) {
                w += edge.getW();
                // Mark the edge as visited 
                visitedEdges.put(edge, true);
            }
        }
        // We are done with this node, mark it as visited
        visitedNodes.put(startNode, true);

        // Check the neighbors of this node recursively 
        Collection neighborNodes = getGraph().getNeighbors(startNode);
        for (Object node : neighborNodes) {
            // Go recursively with this node, passing in the visited nodes and edges maps to avoid recounting
            w += calculateWeight(node, visitedNodes, visitedEdges);                
        }
    }
    return w;
}

// Then, use the above method like this 
public static void main(String... args) { 
    HashMap<Node, Boolean> visitedNodes = new HashMap<Node, Boolean>();
    HashMap<Edge, Boolean> visitedEdges = new HashMap<Edge, Boolean>();

    // Search the startNode and nodeZero from the graph...

    // Add the Node 0 to the visitedNodes map, so the zero node won't be processed 
    visitedNodes.put(nodeZero, true);

    int w = calculateWeight(startNode, visitedNodes, visitedEdges);
}