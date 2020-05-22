printTree( rootNode, 0);

private static void printTree (xmlNode n, int indent) {
    StringBuilder ind = new StringBuilder();
    for (int i = 0; i < indent; i++)
        ind.append(' ');

    // print the Node;
    //
    System.out.println( ind + n.getLabel());

    // traverse Descendants.
    //
    for (xmlNode child : n.getChildren()) {
        printTree( child, indent+1);
    }
}