Comparator<Adjacency> adjacencyComparator = new Comparator<Adjacency>() {

    @Override
    public int compare(Adjacency left, Adjacency right) {
        return left.weight.compareTo(right.weight);
    } 
};