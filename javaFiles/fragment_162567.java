class Tree {

    // The private interface
    private interface Node {
        List<Node> getChildren();
    }      

    // Both are public implementations
    public class InnerNode implements Node {
        @Override 
        public List<Node> getChildren() {  
            return Arrays.<Node>asList(getLeafNode(), getLeafNode());
        }
    }
    public class LeafNode implements Node {
        @Override 
        public List<Node> getChildren() {  
            return Collections.emptyList();
        }
    }

    // These return the concrete, public types
    public InnerNode getInnerNode() { return new InnerNode(); }
    public LeafNode  getLeafNode()  { return new LeafNode();  }

    // This returns the private interface type
    public Node getRootNode() { 

        // Both concrete types can be returned here,
        // because they both implement the interface
        return getInnerNode(); // Works 
        //return getLeafNode(); // Works
    }

    // This uses only the interface type
    public void traverseNode(Node node) {
        System.out.println("Traversing "+node);
        for (Node child : node.getChildren()) {
            traverseNode(child);
        }
    }
}