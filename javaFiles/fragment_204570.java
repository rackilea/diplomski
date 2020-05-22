import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class NewClass extends DefaultHandler {

    public static void main(String[] args) {

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            HashMap<String, String> map = new HashMap();
            String adjustment,ruleVersion,simpleValue;

            DefaultHandler defaultHandler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qname, Attributes attributes) {
                    if(attributes.getLength()>0)
                    {
                        int items = attributes.getLength();
                        System.out.println("Qualified Name:"+qname);
                        for(int i=0;i<items;i++)
                            System.out.println(attributes.getQName(i)+":"+attributes.getValue(i));
                    }

                }
            };
            saxParser.parse("e:\\abc.xml", defaultHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}