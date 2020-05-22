private HashMap<Source, ArrayList<Node>> sourceMap = new HashMap<Source, ArrayList<Node>>();
private HashMap<Target, ArrayList<Node>> targetMap = new HashMap<Target, ArrayList<Node>>();
private HashMap<Cost, ArrayList<Node>> costMap = new HashMap<Cost, ArrayList<Node>>();

/** Look for a node with a given source */
for( Node node : sourceMap.get(keySource) )
{
    /** Test the node for equality with a given node. Equals method below */
    if(node.equals(nodeYouAreLookingFor) { return node; }
}