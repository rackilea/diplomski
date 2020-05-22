doSomethingWithAll(root.getChildNodes());

void doSomethingWithAll(NodeList nodeList)
{
    for (int i = 0; i < nodeList.getLength(); i++) {
        Node childNode = nodeList.item(i);
        if (childNode.getNodeName().equals("person")) {
            //do something with it
        }

        NodeList children = childNode.getChildNodes();
        if (children != null)
        {
            doSomethingWithAll(children);
        }
    }
}