DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        docBuilder = docFactory.newDocumentBuilder();

        Document doc = null;
        InputStream is = getClass().getClassLoader().getResourceAsStream("/payLoadXML.xml");
        doc = docBuilder.parse(is);

        Node staff = doc.getElementsByTagName("m:properties").item(0);

        Text givenNameValue = doc.createTextNode("abc");
        Element givenName = doc.createElement("d:GivenName");
        givenName.appendChild(givenNameValue);
       staff.appendChild(givenName);
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        transformer.transform(source, result);