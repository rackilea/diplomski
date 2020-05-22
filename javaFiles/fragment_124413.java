import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class PriceReader {

    public static void main(String argv[]) {

        try {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        XMLReader xmlReader = saxParser.getXMLReader();

        try {
            xmlReader.setFeature(
                            "http://apache.org/xml/features/continue-after-fatal-error",
                            true);
        } catch (SAXException e) {
            System.out.println("error in setting up parser feature");
        }

        xmlReader.setContentHandler(new PriceHandler());
        xmlReader.setErrorHandler(new MyErrorHandler());
        xmlReader.parse("bin\\com\\test\\stack\\overflow\\sax\\prices.xml");

    } catch (Throwable e) {
         System.out.println("Error -- " +e.getMessage());
    }

    }
}