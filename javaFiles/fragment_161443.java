public int getNextAdjVertex(int currentVertex, int vertexICameFrom) {
    for (int j = vertexICameFrom+1; j < nVerts; j++) {
        if (adjMat[currentVertex][j] == 1 && !vertexList[j].wasVisited) {
            return j;
        }
    }
    return -1;
}