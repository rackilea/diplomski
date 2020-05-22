public int[] getNeighborCount(int vertex) {
    int neighborCount = 0;
    for (int i = 0; i < adj_Matrix_Edges.length; i++){
        if(adj_Matrix_Edges[vertex][i]) {
            neighborCount++;
        }
    }
    return neighborCount;
 }

public int[] getNeighbors(int vertex) {
    int[] neighbors = new int[getNeighborCount()];
    int j = 0;
    for (int i = 0; i < adj_Matrix_Edges.length; i++){
        if(adj_Matrix_Edges[vertex][i]) {
            neighbors[j++] = i;
        }
    }
    return neighbors;
}