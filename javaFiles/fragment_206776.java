XMLReader xr = new XMLFilterImpl(XMLReaderFactory.createXMLReader()) {
        public void startElement(String uri, String localName, String qName, Attributes atts)
                throws SAXException {
            if (qName.equals("page")) {
                super.startElement(uri, localName, qName, atts);
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("page")) {
                super.endElement(uri, localName, qName);
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            //super.characters(ch, start, length);
        }
    };
    Source src = new SAXSource(xr, new InputSource("1.xml"));
    Result res = new StreamResult(System.out);
    TransformerFactory.newInstance().newTransformer().transform(src, res);