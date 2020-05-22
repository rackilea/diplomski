public void addEdge(Vertex<T> start, Vertex<T> end) {
    if (adjMatrix == null) {
        size = vertices.size();
        adjMatrix = new int[size][size];
    }

    int startIndex = vertices.indexOf(start);
    int endIndex = vertices.indexOf(end);
    adjMatrix[startIndex][endIndex] = 1;
    adjMatrix[endIndex][startIndex] = 1;
}