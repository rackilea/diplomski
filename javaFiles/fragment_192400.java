for (int i = 0; i < Nodes.Count(); i++) // iterate nodes
{
    for (int j = 0; j < Nodec.Count(); j++) // search parent of i-th node
    {
        if (Nodes[j].id.Equals(Nodes[i].ParentID)) // j-th node is parent of i-th node
        {
            Nodes[j].sub.add(Nodes[i]); // add i-th node to children of j-th node
        }
    }
}