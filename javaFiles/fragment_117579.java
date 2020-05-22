private HashMap<Integer, ArrayList<Integer>>  edges;

// ...later

Edge e = new Edge(from,to,T);

// ...later

else {
    tmp = new ArrayList();
    edges.put(e.from,tmp);
}
tmp.add(e);