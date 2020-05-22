// AntiSymmetric
public static boolean checkAntisymmetric(Graph graph, int vertices){
    for(int i = 1; i <= vertices; i++) {
        for(int j = 1; j <= vertices; j++){
            if((i != j) && graph.getEdge(i, j) != 0 && graph.getEdge(j, i) != 0) {
                return false;
            }
        }
    }
    return true;
}