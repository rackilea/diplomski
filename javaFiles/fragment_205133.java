/**
     * This method extracts the data found in the doc argument that 
     * corresponds to the tagName and returns it as text. If no data
     * is found, null is returned. Note that this method is only good 
     * for elements that are unique to an XML file, meaning there is only 
     * one of them.
     * 
     * @param doc Fully-loaded DOM Document corresponding to a loaded
     * XML file from which we are loading the data.
     * 
     * @param tagName Name of the tag (i.e. field name) we are looking
     * to load data for.
     * 
     * @return The data in the doc that corresponds to the tagName element.
     * Note that if no data is found, null is returned.
     */
    public String getTextData(Document doc, String tagName)
    {
        // IT WAS FOUND, SO GET THE DATA
        Node node = getNodeWithName(doc, tagName);
        if (node == null)
        {
            return null;
        }
        else
        {
            String data = node.getTextContent();
            return data;   
        }
    }