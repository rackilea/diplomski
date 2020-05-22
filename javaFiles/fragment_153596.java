public void dfs(Vertex obj) {
    obj.marked = true;
    for (Vertex v : obj.Vertices) {
        if (!v.marked) {
            v.parent = obj;
            dfs(v);
        }
    }
}