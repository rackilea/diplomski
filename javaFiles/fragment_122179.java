class Node<T, Q extends Comparable<Q>> implements Comparable<Node<T, Q>> {
    ...
    public final int compareTo(Node<T, Q> node)
    {
        if (node.cost > this.cost)
        {
            return -1;
        }
        else if (node.cost < this.cost)
        {
            return 1;
        }
        else if (node.cost == this.cost)
        {
            return 0;
        }
        return 0;
    }
}