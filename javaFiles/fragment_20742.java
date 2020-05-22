class MyDocumentHandler {
    // The tree we are building
    private Tree tree;
    // The current element we are parsing
    private TreeNode current;

    public void startDocument() {
        // At the beginning of the document, create a new empty tree
        tree = new Tree();
        // The current node is the root
        current = tree;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // Process the new element, read its attributes etc. to create the new TreeNode
        TreeNode child = new TreeNode();
        // Add the newly created node to the current element
        current.addChild(child);

        // The current element is now the child
        current = child;
    }

    public void endElement(String uri, String localName, String qName) {
        // When the current element ends, then return to its parent
        current = current.getParent();
    }
}