int initCapacity = 10;
PriorityQueue<Node> pq = new PriorityQueue<Node>(initCapacity, new Comparator<Node>() {
    public int compare(Node n1, Node n2) {
        // compare n1 and n2
    }
});
// use pq as you would use any PriorityQueue