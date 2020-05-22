PrintWriter outputStream = null;
try
{
    NodeList gidList = xmlDoc.getElementsByTagName("tile");
    for(int i = 0; i < gidList.getLength(); i++)
    {
        Node g = gidList.item(i);
        if(g.getNodeType() == Node.ELEMENT_NODE)
        {
            Element gid = (Element) g;
            String id = gid.getAttribute("gid");
            array[i]=id;
        }
    }

    outputStream = new PrintWriter(fileName);
    for(int j = 0; j < 262144; j++)
    {
        outputStream.println(array[j]);
    }
}

catch(Exception e)
{
    e.printStackTrace();
}
finally
{
    if (outputStream != null)
        outputStream.close(); 
}