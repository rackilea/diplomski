private void writeElement(Element parentNode, Element newNode, String comment)
{
    try
    {
        if (comment != null)
        {
            parentNode.addNodes(new Text("\t"), newNode, new Text(" "), new Comment(" " + comment + " "), new Text("\n\t\t"));
        }
        else
        {
            parentNode.addNodes(new Text("\t"), newNode, new Text("\n\t\t"));
        }
    }
    catch (Exception e)
    {
        LOGGER.warn("Error while writing element", e);
    }
}