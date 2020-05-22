/**
     * This method reads in the xmlFile, validates it against the
     * schemaFile, and if valid, loads it into a WhitespaceFreeXMLDoc
     * and returns it, which helps because that's a much easier
     * format for us to deal with.
     * 
     * @param xmlFile Path and name of xml file to load.
     * 
     * @param schemaFile Path and name of schema file to use for validation.
     * 
     * @return A normalized Document object fully loaded with the data found
     * in the xmlFile.
     * 
     * @throws InvalidXMLFileFormatException Thrown if the xml file validation fails.

     */
    public Document loadXMLDocument(String xmlFile, String xsdFile)
            throws InvalidXMLFileFormatException
    {
        // FIRST VALIDATE
        boolean isValid = validateXMLDoc(xmlFile, xsdFile);
        if (!isValid)
        {
            throw new InvalidXMLFileFormatException(xmlFile, xsdFile);
        }

        // THIS IS JAVA API STUFF
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try
        {            
            // FIRST RETRIEVE AND LOAD THE FILE INTO A TREE
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xmlDoc = db.parse(xmlFile);
            xmlDoc.getDocumentElement().normalize();

            // LET'S RETURN THE DOC
            return xmlDoc;
        }
        // THESE ARE XML-RELATED ERRORS THAT COULD HAPPEN DURING
        // LOADING AND PARSING IF THE XML FILE IS NOT WELL FORMED
        // OR IS NOW WHERE AND WHAT WE SAY IT IS
        catch(ParserConfigurationException | SAXException | IOException pce)
        {
            throw new InvalidXMLFileFormatException(xmlFile);
        }           
    }