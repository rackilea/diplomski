int n;
    List<Integer>[] adj;
    AdjacencyLists(int n0) {
        n = n0;
        adj = (List<Integer>[])new List[n];
        for (int i = 0; i < n; i++) 
            adj[i] = new ArrayStack<Integer>(Integer.class);
    }