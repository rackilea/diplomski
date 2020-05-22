private static Node[][] toArrayLevels(final Node node)
{
    final Queue<Node> temporaryQueue = new LinkedList<Node>(); // Temporary queue is used for level-order traversal.

    final ArrayList<Node[]> tree = new ArrayList<Node[]>(); // Levels containing their nodes.
    ArrayList<Node> nodes = new ArrayList<Node>(); // Current level containing its nodes.

    Node[][] treeArray = new Node[][]{};
    Node[] nodesArray = new Node[]{};

    Node current = node; // Level 0.
    int level = 1; // Node's children are level 1.
    temporaryQueue.add(current);

    nodes.add(current);
    tree.add(nodes.toArray(nodesArray));

    nodes = new ArrayList<Node>(2);

    while (!temporaryQueue.isEmpty())
    {
        // When the nodes completely fill the maximum spaces (2 ^ level) allowed on the current level, start the next level.
        if (nodes.size() >= Math.pow(2, level))
        {
            tree.add(nodes.toArray(nodesArray));
            nodes = new ArrayList<Node>((int) Math.pow(2, level));
            level += 1;
        }

        current = temporaryQueue.remove();

        // Check current's children.
        if (current != null)
        {
            final Node left = current.getLeft();
            final Node right = current.getRight();

            temporaryQueue.add(left);
            nodes.add(left);

            temporaryQueue.add(right);
            nodes.add(right);
        }
        else
        {
            // Null nodes fill spaces used to maintain the structural alignment of the tree.
            nodes.add(null);
            nodes.add(null);
        }
    }

    // Push remaining nodes.
    if (nodes.size() > 0)
    {
        tree.add(nodes.toArray(nodesArray));
    }

    return (tree.toArray(treeArray));
}