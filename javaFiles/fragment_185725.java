Document newDocument = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder().newDocument();
    WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
            newDocument );

    wordToHtmlConverter.processDocument( hwpfDocument );

    StringWriter stringWriter = new StringWriter();
    Transformer transformer = TransformerFactory.newInstance()
            .newTransformer();
    transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
    transformer.setOutputProperty( OutputKeys.ENCODING, "utf-8" );
    transformer.setOutputProperty( OutputKeys.METHOD, "html" );
    transformer.transform(
            new DOMSource( wordToHtmlConverter.getDocument() ),
            new StreamResult( stringWriter ) );

    String html = stringWriter.toString();