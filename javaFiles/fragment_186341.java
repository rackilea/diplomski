public static void reverse(List<Edge> graph) {
    for (int i = 0 ; i < graph.size() ; i++) {
        int temp1 = graph.get(i).getFirstNode();
        int temp2 = graph.get(i).getSecondNode();
        EdgeImpl newEdge = new EdgeImpl(temp2, temp1);
        graph.set(i, newEdge); // this overwrites the element in the list at position i.
    }
}