JAXBContext jc = JAXBContext.newInstance("com.jmex.model.collada.collada_schema_1_4");
            Unmarshaller u = jc.createUnmarshaller();
            SAXParserFactory parserFactory;
            parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(false);
            XMLReader reader = parserFactory.newSAXParser().getXMLReader();
            Source er = new SAXSource(reader, new InputSource(sourceStream));
            HSIContractInventoryModificationRS hsi = (HSIContractInventoryModificationRS) u.unmarshal(er);