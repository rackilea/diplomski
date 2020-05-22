import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class YourHandler extends DefaultHandler {
    String tag = "params"; // needed tag
    String city = "city"; // name of the attribute
    String value; // your value of the city

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(localName.equals(tag)) {
            value = attributes.getValue(city);
        }
    }

    public String getValue() {
        return value;
    }
}`