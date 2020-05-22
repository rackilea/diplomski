Map<Node, List<Node>> neighbors;
Map<String, Node> nodeByCoords;

// Get node by it's coordinates. Create new node, if it doesn't exist.
Node getNode(String coords) {
    String[] crds = coords.split(" ");
    int x = Integer.parseInt(crds[0]);
    int y = Integer.parseInt(crds[1]);
    String key = x + " " + y;
    if (!nodeByCoords.containsKey(key)) {
        Node node = new Node();
        node.setX(x);
        node.setY(y);
        nodeByCoords.put(key, node);
        neighbords.put(node, new ArrayList<Node>());
    }
    return nodeByCoords.get(key);
}

// Create node (if not exists) and add neighbors.
void List<String> readNode(List<String> description) {
    Node node = getNode(description.get(1));
    node.setName(description.get(0));

    for (int i = 2; i < description.size(); i++) {
        Node neighbor = getNode(description.get(i));
        neighbors.get(node).add(neighbor);
    }
}

// Splits lines to groups. Each group describes particular node.
List<List<String>> splitLinesByGroups (String filename) {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    List<List<String>> groups = new ArrayList<List<String>>();
    List<String> group = new ArrayList<String>();
    while (reader.ready()) {
        String line = reader.readLine();
        if (Character.isLetter(line.charAt())) {
            groups.add(group);
            group = new ArrayList<String>();
        }
        group.add(line);
    }
    groups.add(group);
    return groups;
}

// Read file, split it to groups and read nodes from groups.
void readGraph(String filename) {
    List<List<String>> groups = splitLineByGroups(filename);
    for (List<String> group: groups) {
        readNode(group);
    }
}