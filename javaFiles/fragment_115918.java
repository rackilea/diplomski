bool areEquivalent(Node r1, Node r2)
{
    Stack<Node> s1 = new Stack<Node>();
    Stack<Node> s2 = new Stack<Node>();
    Node n1, n2;

    s1.Push(r1);
    s2.Push(r2);
    while(true) // Need a better check
    {
        if(s1.getCount() != s2.getCount())
        {
            return false;
        }
        if(s1.getCount() == 0) // if both stacks are empty then we've traversed both trees without failure.
        {
            return true;
        }
        n1 = s1.Pop();
        n2 = s2.Pop();
        if(!areEquivalentNodes(n1, n2))
        {
            return false;
        }
        foreach(Node child in n1.children)
        {
            s1.Push(child);
        }
        foreach(Node child in n2.children)
        {
            s2.Push(child);
        }
    }
}

// only checks the two nodes are equivalent. their childrens' equivalence will be handled by other calls to this method.
bool areEquivalentNodes(Node n1, Node n2)
{
    if(n1.children.getCount() != n2.children.getCount())
    {
        return false;
    }
    if(n1.children.getCount() == 0) // if both are leaf nodes...
    {
        if(n1.ref != n2.ref)
        {
            return false;
        }
    }
    else // both are non-leaf
    {
        if(n1.type != n2.type)
        {
            return false;
        }
        // the condition that children of non-leaf nodes be equivalent will be covered by subsequent calls this method...
    }

    return true;
}