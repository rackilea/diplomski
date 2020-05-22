bool areEquivalent(Node r1, Node r2)
{
    if(r1.children == null && r2.children == null)
    {
        return (haveSameOriginalTree(r1, r2) && (r1.ref == r2.ref));
    }
    if((r1.children == null && r2.children != null) || (r1.children != null && r2.children == null))
    {
        return false;
    }
    // if here then both must be non-leaf nodes
    if(r1.type != r2.type)
    {
        return false;
    }
    if(r1.children.getCount() != r2.children.getCount()) // not sure of correct syntax for Java Sets
    {
        return false;
    }
    for(int i=0; i<r1.children.getCount(); i++)
    {
        if(!areEquivalent(r1.children[i], r2.children[i])) // again please correct the syntax for Sets
        {
            return false;
        }
    }

    return true;
}