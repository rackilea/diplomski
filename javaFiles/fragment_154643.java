org.xml.sax.XMLReader reader = XMLReaderFactory.createXMLReader();

     EntityResolver ent = new EntityResolver() {

        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {

            System.out.println(publicId);
            System.out.println(systemId);

            if(publicId.equals("-//OASIS//DTD DITA BookMap//EN")){
                return new InputSource("file:///D:/dtd/bookmap/dtd/bookmap.dtd");
            }

            if(systemId.equals("file:///D:/doc/maps/bookmap.dtd")){
                return new InputSource("file:////dtd/bookmap/dtd/bookmap.dtd");
            }
            return null;
            }
        };



        reader.setEntityResolver(ent);

        SAXSource source = new SAXSource(reader, new InputSource(xmlf));