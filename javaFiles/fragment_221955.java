public class ReadAuthors {

    public void parse(String filePath) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bName = false;
                String fullName = "";

                @Override
                public void startElement(String uri, String localName,String qName,
                            Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("FamilyName")) {
                        bName = true;
                    }

                    if (qName.equalsIgnoreCase("GivenName")) {
                        bName = true;
                    }

                    if (qName.equalsIgnoreCase("Author")) {
                        fullName = "";
                    }

            }

            @Override
            public void endElement(String uri, String localName,
                String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("Author")) {
                        System.out.println("Full Name : " + fullName);
                    }
            }

            @Override
            public void characters(char ch[], int start, int length) throws SAXException {

                String name = "";

                if (bName) {
                    name = new String(ch, start, length);
                    fullName += name;
                    bName = false;
                }

            }
             };

             saxParser.parse(filePath, handler);

        } catch (Exception e) {
               e.printStackTrace();
        }
   }

}