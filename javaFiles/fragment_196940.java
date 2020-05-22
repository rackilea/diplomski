import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
// ...
public static void main(String args[]) throws Exception {
        if (args.length == 0 || args.length > 2) {
            System.err.println("Usage: java Validator <doc.xml> [<schema.xsd>]");
            System.exit(1);
        }
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.    W3C_XML_SCHEMA_NS_URI);
        String xsdpath = "book.xsd";
        if (args.length == 2) {
            xsdpath = args[1];
        }
        Schema s = sf.newSchema(new File(xsdpath));
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);
        factory.setSchema(s);

        XMLReader parser = factory.newSAXParser().getXMLReader();
        parser.setFeature("http://xml.org/sax/features/namespaces", true);
        parser.setFeature("http://xml.org/sax/features/namespace-prefixes", false);

        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        parser.setContentHandler(new MyHandler(out));
        parser.setErrorHandler(new DefaultHandler());
        parser.parse(args[0]);
    }
}