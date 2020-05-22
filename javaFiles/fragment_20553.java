private String OPEN_GRAPH = "digraph G { \n";
private String NODE = "{0} [label='{1}']; \n";
private String EDGE = "{0} -> {1}; \n";
private String CLOSE_GRAPH = "} \n";

public void format(Appendable sb) throws IOException {
    sb.append(OPEN_GRAPH);

    //Render nodes
    for (Node node : graph.getNodes().values()) {
        sb.append(MessageFormat.format(NODE, node.getId(), node.getName()));

        //Render edges for node
        for (String targetEdge : node.getEdges()) {
            sb.append(MessageFormat.format(EDGE, node.getId(), targetEdge));
        }
    }

    sb.append(CLOSE_GRAPH);
}