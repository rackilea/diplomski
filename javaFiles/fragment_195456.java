class Node implements Comparable<Node>
{
    int x, y, dir;
    /** the order in which the node was inserted into the priority queue (if it was) */
    int insertionOrder;

    Node(int x, int y, int dir, int insertionOrder)
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.insertionOrder = insertionOrder;
    }

    public int compareTo(Node o)
    {
        int d = Ideone.cost[x][y] - Ideone.cost[o.x][o.y];
        if (d == 0) {
            // keep insertion order
            return insertionOrder - o.insertionOrder;
        } else {
            return d;
        }
    }
}