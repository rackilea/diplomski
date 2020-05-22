TraversalDescription bothSide = database.traversalDescription().depthFirst()
    .relationships(CITY, OUTGOING)
    .relationships(REGION, OUTGOING)
    .relationships(COUNTRY, OUTGOING)
    .relationships(CONTINENT, OUTGOING)
    .uniqueness(NODE_PATH);

Traverser traverser = database
    .bidirectionalTraversalDescription()
    .startSide(bothSide)
    .endSide(bothSide)
    .traverse(node, endNode);