private void listNodes(Node node, String indent)
{
    if (node instanceof Text) {
        String value = node.getNodeValue().trim();
        if (value.equals("") ) {
            return;
        }
    }

    String nodeName = node.getNodeName();
    System.out.println(indent + " Node is: " + nodeName);
    ...