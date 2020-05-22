private static void searchForDataValidation(Node node, List<Node> nodesInQuestion)
{
    if (StringUtils.equalsIgnoreCase("x14:dataValidation", node.getNodeName()))
    {
        nodesInQuestion.add(node);
        return;
    }

    for (int i = 0; i < node.getChildNodes().getLength(); i++)
    {
        searchForDataValidation(node.getChildNodes().item(i), nodesInQuestion);
    }
}