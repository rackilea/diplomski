XMLInputFactory f = XMLInputFactory.newInstance();
    XMLStreamReader rdr = f.createXMLStreamReader(new FileReader("test.xml"));
    while (rdr.hasNext()) {
        if (rdr.next() == XMLStreamConstants.START_ELEMENT) {
            if (rdr.getLocalName().equals("Item")) {
                System.out.println(rdr.getAttributeValue("", "Name"));
                System.out.println(rdr.getElementText());
            }
        }
    }