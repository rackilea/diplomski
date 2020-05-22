import java.io.StringReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

public class Problem{

    public static void main(String[] args) throws Exception {
        String xml = "<!DOCTYPE html><hml><img/></hml>";
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        InputSource in = new InputSource(new StringReader(xml));

        DefaultHandler2 myHandler = new DefaultHandler2(){
            @Override
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                System.out.println("Element: " + qName);
            }

            @Override
            public void startDTD(String name,  String publicId,
            String systemId) throws SAXException {
                System.out.println("DocType: " + name);
            }
        };
        saxParser.setProperty("http://xml.org/sax/properties/lexical-handler",
                               myHandler);
        saxParser.parse(in, myHandler);
    }
}