public List<Integer> getNeighbors(int vertex) {
    List<Integer> neighbors = new ArrayList<Integer>();
    for (int i = 0; i < adj_Matrix_Edges.length; i++){
        if(adj_Matrix_Edges[vertex][i]) {
            neighbors.add(i);
        }
    }
    return neighbors;
}