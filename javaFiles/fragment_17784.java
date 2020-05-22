String input = "<flow><TaskID>100</TaskID><TaskID>101</TaskID><TaskID>102</TaskID><TaskID>103</TaskID></flow>";
SAXParser sax = SAXParserFactory.newInstance().newSAXParser();
DefaultHandler handler = new DefaultHandler() {
    private StringBuilder buffer = new StringBuilder();
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if ("TaskID".equals(qName)) {
            System.out.println(buffer);
            buffer = new StringBuilder();
        }
    }
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        buffer.append(ch, start, length);
    }
    @Override
    public void startElement(String uri, String localName,
            String qName, Attributes attributes) throws SAXException {
        buffer = new StringBuilder();
    }
};
sax.parse(new InputSource(new StringReader(input)), handler);