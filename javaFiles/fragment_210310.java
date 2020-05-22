NodeList ttStatus = Te.getElementsByTagName("Status");
    for (int j = 0; j < ttStatus.getLength(); j++)
    {
       Node nNode = ttStatus.item(j);
       if (nNode.getParentNode().getNodeName().equals("LineStatus")) {
           Element eElement = (Element) nNode;
           listLineStatuses.add(eElement.getAttribute("Description"));
       }
    }