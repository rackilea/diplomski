public Node findNode(String name, Node localTree)
{
    Node current = localTree;

    // Visit the node
    if(current.name.equals(name))
        return current;

    // Pre-order - go left
    if(current.leftChild != null)
    {
        System.out.println("going left to " + current.leftChild);
        Node nodeFound = findNode(name, current.leftChild);
        if ( nodeFound != null ) {
          // Only return from findNode if we have already found what we're looking for.
          return nodeFound;
        }
    }

    // Pre-order - go right
    if(current.rightChild != null)
    {
        System.out.println("going right to " + current.rightChild);
        return findNode(name, current.rightChild);
    }

    return null;
}