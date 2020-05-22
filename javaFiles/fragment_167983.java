public List<Node> explore(File directory) {
    List<Node> result = new ArrayList<Node>();

    for (File current : directory.listFiles()) {
        Node node = toNode(current);
        // do the real work here

        if (file.isDirectory()) {
            node.setChildren(explore(file));
        }

        result.add(node);
    }

    return result;
}