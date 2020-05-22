public void startElement(final String uri, 
    final String localName, final String qName, final Attributes attributes) throws SAXException {

    final String fixedQName = qName.toLowerCase();
    switch (fixedQName) {
         case "item":
             prod = new Product();
             break;
         case "status":
             prod.setItem(content);
             break;
    }
}