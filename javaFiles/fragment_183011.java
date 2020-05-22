for (i = 0; i < n - 1; ++i) {
    for (j = 0; j < e; ++j) { //here i am calculating the shortest path
        if (d[edges.get(j).u] + edges.get(j).w < d[edges.get(j).v]) {
            d[edges.get(j).v] = d[edges.get(j).u] + edges.get(j).w;
            p[edges.get(j).v] = edges.get(j).u;
        }
    }
}