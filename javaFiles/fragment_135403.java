Long dfs(Integer node, Long mini) {
    // Stores the minimum
    mini = Math.min(mini, costs[(Integer) node]);

    // Marks node as visited
    visited[(Integer) node] = true;

    // Traversed in all the connected nodes
    for (Integer i : graph[(Integer) node]) {
        if (!visited[(Integer) i])
            mini = dfs(i, mini);
    }

    return mini;
}

void minimumSumConnectedComponents() {
    // Initially sum is 0
    Long sum = 0L;

    // Traverse for all nodes
    for (Integer i = 0; i < numberOfVertices; i++) {
        if (!visited[i]) {
            sum += dfs(i, costs[i]);
        }
    }

    // Returns the answer

    System.out.println(sum);
}