package forum13397834;

import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        XMLReader xmlReader = spf.newSAXParser().getXMLReader();

        LookAheadUnmarshallerHandler handler = new LookAheadUnmarshallerHandler(xmlReader);
        xmlReader.setContentHandler(handler);
        xmlReader.parse(new InputSource("src/forum13397834/input.xml"));
        Object object = handler.getResult();
        System.out.println(object.getClass());
    }

}