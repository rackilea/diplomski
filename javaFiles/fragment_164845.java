String basePromptExpression = "/AudioLibrary/prompt";

NodeList nodes  = (NodeList) xPathObject.evaluate(basePromptExpression, promptInputSource, XPathConstants.NODESET);

for (int nodeIndex = 0; nodeIndex < nodes.getLength(); nodeIndex++)
{
    Node singleNode = nodes.item(nodeIndex);
    String promptName = singleNode.getAttributes().getNamedItem("name").getNodeValue();
    String promptSrc = findNode(singleNode, "audiofile").getAttributes().getNamedItem("src").getNodeValue();
    String promptText = findNode(singleNode, "audiofile").getAttributes().getNamedItem("text").getNodeValue();

    System.out.println("Name: "+promptName+" Src: "+promptSrc+" Text: "+promptText);
}


private static Node findNode(Node singleNode, String nodeName)
{
    Node namedNode=null;
    NodeList nodeChildren = singleNode.getChildNodes();
    Node childNode = null;

    for (int nodeIndex =0; nodeIndex < nodeChildren.getLength(); nodeIndex++)
    {
        childNode = nodeChildren.item(nodeIndex);

        if (childNode.hasChildNodes())
        {
            childNode = findNode(childNode, nodeName);
        }

        if (childNode.getNodeName().equals(nodeName))
        {
            namedNode = childNode;
            return namedNode;
        }
    }

    return namedNode;
}