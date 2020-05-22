boolean adj_Matrix_Edges[][];
List<Node> nodes;

void initializeMatrix()
{
    adj_Matrix_Edges = ...;

    // Create the nodes
    Random random = new Random(0);
    nodes= new ArrayList<Node>();
    for (int m = 0; m < adj_Matrix_Edges.length; m++)
    {
        Node node= new Node();
        node.name = Integer.toHexString(m);
        node.x = random.nextDouble(); 
        node.y = random.nextDouble(); 
        nodes.add(node);
    }
}