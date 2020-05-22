DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    String FEATURE = null;
    try {

        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
        dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        dbf.setXIncludeAware(false);
        dbf.setExpandEntityReferences(false);


    } catch (ParserConfigurationException e) {
        // This should catch a failed setFeature feature


    } catch (SAXException e) {
        // On Apache, this should be thrown when disallowing DOCTYPE

    } catch (IOException e) {
        // XXE that points to a file that doesn't exist

    }

// Load XML file or stream using a XXE agnostic configured parser...
        DocumentBuilder safebuilder = dbf.newDocumentBuilder();