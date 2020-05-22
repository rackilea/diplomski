public boolean prog(Node n)
{
    Queue<Node> FIFO = new LinkedList<Node>();
    List<Node> close = new LinkedList<Node>();

    FIFO.add(n);
    while (!FIFO.empty()) {
        n = FIFO.poll();
        if( n.isTarget() )
            return true;         
        for (int i = 0; i < n.expand().size(); i++) {
            Node nxt = n.expand().get(i); // Note dukeling suggestion here, I don't know what's behind expand()
            if (!close.contains(nxt)) {
                FIFO.add(nxt); close.add(nxt);
            }
        }
    }
    return false;
}