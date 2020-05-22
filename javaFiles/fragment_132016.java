public int allCyclesDirectedmain(){
    clearAll();
    int[] count = new int[1];
    for (Vertex v: vertexMap.values()){
        dfs(v,v,count);
        v.setVisited(true); // <---
    }
    return count[0];
}