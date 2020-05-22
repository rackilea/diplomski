DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document input = builder.parse(args[0]);

    Element root = input.getDocumentElement();
    printNSInfo(root);