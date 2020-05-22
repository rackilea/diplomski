@Override
public void endElement(String uri, String localName,
                       String qName) throws SAXException {
    if ("fileContent".equalsIgnoreCase(qName)) {
        try {
            Files.write(Paths.get("temp.xls"), DatatypeConverter.parseBase64Binary(value.toString()));
        } catch (IOException ex) {
            Logger.getLogger(SaxSample.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        // I'm still not sure why you're printing this ... debugging?
        System.out.println(qName + " = " + value);
    }
}