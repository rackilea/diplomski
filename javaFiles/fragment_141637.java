static final String NODE_BASE_NAME = "node_%d";

public Map<String, Node> makeThisManyNodes(int count) {
    Map<String, Node> nodes = new HashMap<String, Node>();
    String key;
    for (int i=0; i<count; i++) {
        key = String.format(NODE_BASE_NAME, i);
        nodes.put(key, new Node());
    }
    return nodes;
}