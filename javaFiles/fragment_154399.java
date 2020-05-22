private CostedPath processPath(String start, String end, List<String> path, Graph graph) {
{
    String previous = path.get(path.indexOf(end) + 1);
    if (previous.equals(start))
        return new CostedPath(start);
    else
        return processPath(start, previous, path, graph).addNode(end, graph);
}