for (int v = 0; v < adjMatrix[u].length; v++) {
    if (adjMatrix[u][v] != null && !used(v))
    // If there exists an edge between (u, v), and haven't visited v yet.
    {
         dfs(adjMatrix, used, res, v); // visit v
    }
}