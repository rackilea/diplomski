import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLReader {
    private Reader reader = new Reader();
    private class Reader extends DefaultHandler {
        private List<String> textList = new ArrayList<String>();
        private CharArrayWriter text;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            text = new CharArrayWriter();
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equalsIgnoreCase("text")) {
                textList.add(text.toString().trim());
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            text.write(ch, start, length);
        }

        public List<String> getTextList() {
            return textList;
        }
    }
    public List<String> getTextList() {
        return reader.getTextList();
    }

    public void load() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new FileInputStream("any.xml"), reader);
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
    public static void main(String[] args) {
        XMLReader reader = new XMLReader();
        reader.load();
        List<String> textList = reader.getTextList();
        for(String text : textList) {
            System.out.println(text);
        }
    }
}