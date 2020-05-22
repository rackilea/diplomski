public Graph<String> createGraph(Scanner in) {
    String line;
    String[] elements;
    Graph<String> graph = new Graph<>();
    while (in.hasNextLine()) {
        line = in.nextLine();
        elements = line.split("\\s+");
        graph.insertVertex(elements[0]);
    }
    // ...
    // Anything else, like adding edges
    // ...
    return graph;
}