public class SAXReaderExample {

    public static final String PATH = "src/main/resources"; // this is where I put the XML file

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        // Obtain XML Reader
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader reader = sp.getXMLReader();

        // Instantiate SAX handler
        ExtractMovieSaxHandler handler = new ExtractMovieSaxHandler();

        // set search criteria
        handler.setSearchCriteria("Director", "Kubrick", false);

        // Register handler with XML reader
        reader.setContentHandler(handler);

        // Parse the XML
        reader.parse(new InputSource(new FileInputStream(new File(PATH, "source.xml"))));
    }
}