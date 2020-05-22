while (it.hasNext()){
        Node1 n = it.next();
        int vert = n.getNode();
        if( !visited[vert] || (visited[vert] && (distances[vert] > distances[u] + w)){
            visited[vert] = true;
            int w = n.getWeight();
            if (distances[vert] > distances[u] + w){
                distances[vert] = distances[u] + w;
                parent[vert] = u;

            }
            p.offer(new Node1(vert, distances[vert]));
       }
    }