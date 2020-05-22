PriorityQueue<Edge> queue=new PriorityQueue<Edge>(10, new Comparator<Edge>() {
    public int compare(Edge edge1, Edge edge2) {
        if (edge1.getWeight() < edge2.getWeight()) return -1;
        if (edge1.getWeight() > edge2.getWeight()) return 1;
        return 0;
    }
});