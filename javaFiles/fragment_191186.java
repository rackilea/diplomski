try {
        String namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
        configProperties.load(SecurityTokenHandler.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        Document requestDoc = documentBuilderFactory.newDocumentBuilder().parse(SecurityTokenHandler.class.getClassLoader().getResourceAsStream(SOAP_REQUEST_FILE));
        Element docElement = requestDoc.getDocumentElement();
        docElement.getElementsByTagNameNS(namespace, "Username").item(0).setTextContent(configProperties.getProperty("username"));
        docElement.getElementsByTagNameNS(namespace,"Password").item(0).setTextContent(configProperties.getProperty("password"));
        Transformer docTransformer = TransformerFactory.newInstance().newTransformer();
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            StreamResult result = new StreamResult(byteArrayOutputStream);
            DOMSource source = new DOMSource(requestDoc);
            docTransformer.transform(source, result);
            b = byteArrayOutputStream.toByteArray();
        }
    } catch(IOException | ParserConfigurationException | SAXException | TransformerException exception) {
        LOGGER.error("There was an error loading the properties file", exception);
    }