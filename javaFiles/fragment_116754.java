enum NodeType { // Name of the enum is NodeType
    TEXT_NODE, ATTR_NODE
}
class Node {
    NodeType nodeType; // A field of type NodeType
    public Node(NodeType nodeType) {
        this.nodeType = nodeType;
    }
}
class CreateNode {
    Node returnNode() {
        return new Node(NodeType.TEXT_NODE); // return the TEXT_NODE
    }
}