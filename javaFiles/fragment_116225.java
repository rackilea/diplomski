private void setVertices() {

    String[] listEdges;

    for(int i=0; i<nodes.size(); i++) {

        //if vertex does not exist, create it
        if(vertexList.containsKey(nodes.get(i))) {
            vertexList.put(nodes.get(i), new Vertex(nodes.get(i)));
        }

        line = adjLine.get(i);

        //separate adj edges to *
        if(line.contains("*")) {
            listEdges = line.split("[*]");
        } else {
            listEdges = new String[1];
            listEdges[0] = line;
        }

        //add edges to specified vertex
        for(int j=0; j < listEdges.length; j++ ) {
            String[] word = listEdges[j].split(",");
            edges.add(new Edge(vertexList.get(word[0]),Double.parseDouble(word[1])));
        }

        map.put(nodes.get(i), edges);
        edges.clear();
    }
}