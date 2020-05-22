public static void main(String[] args) {
    Graph g = new Graph();
    Vertex source = g.Vertices.get(0);
    g.dfs(source);

    for(Vertex v:g.Vertices){
        if (v!= source && v.marked){
            System.out.println(v.vertexNumber+":"+v.parent.vertexNumber);
        }
    }
}