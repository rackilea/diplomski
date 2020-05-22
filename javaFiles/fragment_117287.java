private void xmlParsing(Node node, int indent) throws IOException {

    // iterate for siblings
    while (node != null) {

        // recurse for children
        if (node.hasChildNodes()) {
            Node firstChild = node.getFirstChild();
            xmlParsing(firstChild, indent + 1);
        } else {
            // do the leaf node action
        }

        node = node.getNextSibling();
    }
}