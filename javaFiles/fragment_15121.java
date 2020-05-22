public void addEdge(DirectedEdge e)
{
    String v = e.from();
    String w = e.to();

    // Check if there is already an edge array
    ArrayList<DirectedEdge> item = adjacencyList.get(v);
    if(item == null) {
        // Does not exist, create it
        item = new ArrayList<DirectedEdge>();
    }
    item.add(e);
    adjacencyList.put(v, item);
    System.out.println(v+item);
}