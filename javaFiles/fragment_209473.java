static class Node implements Comparator<Node> {
    int id;

    public Node(int id) {
        this.id = id;

    }

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.id < o2.id)
            return -1;
        if (o1.id > o2.id)
            return 1;
        return 0;
    }
}