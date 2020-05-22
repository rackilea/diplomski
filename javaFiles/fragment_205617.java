public boolean removeEdge(Node<T> node)
{
    Edge<T> e = findEdge(node);
    if (e != null)
    {
        return edges.remove(e);
    }
    return false;
}

public boolean hasEdge(Node<T> node)
{
    return findEdge(node) != null;
}