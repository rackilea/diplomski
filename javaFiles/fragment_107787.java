import java.io.StringReader;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NumCountHandler extends DefaultHandler {

    private HashMap<String, Integer> countOfNum = new HashMap<String, Integer>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("SUB")) {
            String attributeNum = attributes.getValue("NUM");
            // System.out.println("Here" + qName +"" + );
            if (countOfNum.containsKey(attributeNum)) {
                Integer count = countOfNum.get(attributeNum);
                countOfNum.put(attributeNum, new Integer(count.intValue() + 1));
            } else {
                countOfNum.put(attributeNum, new Integer(1));
            }
        }
    }

    public static void main(String[] args) {

        try {
            String xml = "<EXAMPLE DATE=\"20160830\"> <SUB NUM=\"1\">  <NAME>Peter</NAME> </SUB> <SUB NUM=\"2\">  <NAME>Mary</NAME> </SUB></EXAMPLE>";
            InputSource is = new InputSource(new StringReader(xml));

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            NumCountHandler userhandler = new NumCountHandler();
            saxParser.parse(is, userhandler);

            userhandler.countOfNum
                    .forEach((k, v) -> System.out.println("SUB NUM [" + k + "]" + "Length with tap name :[" + v + "]"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}