public class App {
    ...   
    public static void check(InputStream stream) {    
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(true);
        MyHandler handler = new MyHandler();
        try (InputStream schemaStream = App.class.getResourceAsStream("/appContext.xsd")) {
            SAXParser sp = spf.newSAXParser();
            sp.setProperty(JAXPConstants.JAXP_SCHEMA_LANGUAGE, JAXPConstants.W3C_XML_SCHEMA);
            sp.setProperty(JAXPConstants.JAXP_SCHEMA_SOURCE, new InputSource(schemaStream));
            XMLReader rdr = sp.getXMLReader();
            rdr.setContentHandler(handler);
            rdr.setErrorHandler(new MyErrorHandler());
            rdr.parse(new InputSource(stream));
        }
        ...
    }
    ...
}