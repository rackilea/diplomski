static private class Node implements Comparable<Node> {

    private static int count = 0;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, int position) {
        this(value);
        this.position = position;
    }

    private int value;
    private int position;
    private boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void markVisited() {
        visited = true;
    }

    @Override
    public int compareTo(Node o) {
        if (this.value >= o.value) {
            return 1;
        }
        return -1;
    }
}