import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PriceHandler extends DefaultHandler {

    public void startElement(String uri, String localName,
        String qName, Attributes attributes)
        throws SAXException {

    if (qName.equalsIgnoreCase("Product")) {
        System.out.println("Product ::: "+ attributes.getValue("Name"));
    }
  }
}