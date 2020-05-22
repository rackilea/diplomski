/**
     * This method can be used to get the node in the document
     * that is an element of type tagName. null is returned
     * if none is found.
     * 
     * @param doc The XML document to search
     * 
     * @param tagName The name of the XML element/tag to
     * search for.
     * 
     * @return The first node found named tagName. If none is
     * found in the document, null is returned.
     */
    public Node getNodeWithName(Document doc, String tagName)
    {
         // GET THE NODE FOR THE tagName ELEMENT
        NodeList nodeList = doc.getElementsByTagName(tagName);

        // IF NOT FOUND, DON'T GO ON
        if (nodeList.getLength() == 0)
        {
            return null;
        }

        // IT WAS FOUND, SO GET THE DATA
        Node node = nodeList.item(0);
        return node;
    }