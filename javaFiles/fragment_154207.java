public class AddChild1_wy_v1    {
    public static void main(String args[]) // note that I don't throw the Exception.
    {
      try {
        if (args.length == 0) {
            System.err.println("Usage: java DumpXML file.xml");
            Runtime.getRuntime().exit(1);
        }

        IXMLParser parser = XMLParserFactory.createDefaultXMLParser();
        IXMLReader reader = StdXMLReader.fileReader(args[0]);
        parser.setReader(reader);
        XMLElement xml = (XMLElement) parser.parse();

        xml.addChild (null);
        (new XMLWriter(System.out)).write(xml); 
      } catch (Exception any) {
        any.printStackTrace(System.out); // note that I send the Stack Trace to standard out here.
      }
    }
}