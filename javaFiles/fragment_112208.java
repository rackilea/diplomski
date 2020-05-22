for( int i = 0; i <= elements.length - 1; i++)
{
    nodeDBList = (NodeList) xPath.compile(elements[i]).evaluate(dbDocument, XPathConstants.NODESET);
    for (int j = 0; j < nodeDBList.getLength(); j++) {
        if(nodeDBList.item(j).getFirstChild() != null) {
            String oldVal = dbList.put(nodeDBList.item(j).getFirstChild().getNodeValue().toLowerCase().trim(), nodeDBList.item(j).getNodeName().toLowerCase().trim());
            if (oldVal != null) {
                System.out.println(oldVal);
            }
        }
    }
}