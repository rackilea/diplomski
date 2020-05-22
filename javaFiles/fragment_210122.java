public void topologicalSort() {
    result.clear();

    // calculate in-degrees

    int in_degree = new int[V]; //initialized to zeros
    for (int i = 0; i < V; ++i) {
        for(Integer target: adj[i]) {
          ++in_degree[target];
        }
    }

    // add start nodes to result

    for (int i = 0; i < V; ++i) {
        if (in_degree[i]==0) {
            result.add(i);
        }
    }

    // uncount edges from added nodes to find new nodes to add

    for (int scanpos=0; scanpos < result.size(); ++scanpos) {
        for(Integer target: adj[result.get(scanpos)]) {
            if (--in_degree[target] == 0) {
                result.add(target);
            }
        }
    }

    //done
    if (result.size() < V) {
        throw new RuntimeException("Ack! a cycle!");
    }
}