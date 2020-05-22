class Edge {

    private Vertex to; 
    private int weight;

    public Edge(Vertex to, int weight) {
        super();
        this.to = to;
        this.weight = weight;
    }

    Vertex getTo() {
        return to;
    }

    int getWeight() {
        return weight;
    }   

    //todo override hashCode()
}