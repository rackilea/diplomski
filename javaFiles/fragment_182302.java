try {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser parser = factory.newSAXParser();
    parser.parse(yourFile, new YourHandler());
} catch (ParserConfigurationException e) {
    System.err.println(e.getMessage());
}