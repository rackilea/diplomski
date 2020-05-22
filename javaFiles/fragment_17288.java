Set<Node> found = new HashSet<Node>();
for ( Relationship firstRel : a1.getRelationships( Reltypes.x, Direction.OUTGOING ) )
{
    Node cNode = firstRel.getEndNode();
    for ( Relationship secondRel : cNode.getRelationships( Reltypes.y, Direction.INCOMING ) )
    {
        Node bNode = secondRel.getStartNode();
        if ( bNode.equals( b1 ) )
        {
            found.add( cNode );
            break;
        }
    }
}