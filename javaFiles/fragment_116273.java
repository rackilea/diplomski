private static void getDataValidationInfo(Node node, ExtendedDataValidations dataValidations)
{
    if (StringUtils.equalsIgnoreCase("#text", node.getNodeName()))
    {
        if (StringUtils.equalsIgnoreCase("xm:sqref", node.getParentNode().getNodeName()))
        {
            dataValidations.sqref = node.getNodeValue();
        }
        else if (StringUtils.equalsIgnoreCase("xm:f", node.getParentNode().getNodeName()))
        {
            dataValidations.formula = node.getNodeValue();
        }
        return;
    }

    for (int i = 0; i < node.getChildNodes().getLength(); i++)
    {
        getDataValidationInfo(node.getChildNodes().item(i), dataValidations);
    }
}