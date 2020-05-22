static class Node implements Comparable<Node> {
    int id;

    public Node(int id) {
        this.id = id;

    }
    @Override
    public int compareTo(Node o) {
        // Or, easier: return Integer.compare(this.id, o.id);
        if (this.id < o.id)
            return -1;
        if (this.id > o.id)
            return 1;
        return 0;
    }
}