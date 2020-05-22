public void explore(File directory, Node parent) {
    for (File current : directory.listFiles()) {
        Node node = toNode(current);
        // do the real work here

        if (file.isDirectory()) {
            explore(file, node);
        }

        parent.add(node);
    }
}