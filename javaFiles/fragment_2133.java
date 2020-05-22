package forum13397834;

import java.util.*;
import javax.xml.bind.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class LookAheadUnmarshallerHandler extends DefaultHandler {

    private XMLReader xmlReader;
    private List<Event> events = new ArrayList<Event>();
    private UnmarshallerHandler unmarshallerHandler;

    public LookAheadUnmarshallerHandler(XMLReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        events.add(new StartElement(uri, localName, qName, attributes));
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if("id".equals(localName) || "id".equals(qName)) {
            Characters characters = (Characters) events.get(events.size() - 1);
            String value = characters.getString();
            JAXBContext jc;
            try {
                if("1234".equals(value)) {
                    jc = JAXBContext.newInstance(Root1.class);
                } else if("5678".equals(value)) {
                    jc = JAXBContext.newInstance(Root2.class);
                } else {
                    jc = JAXBContext.newInstance(Root3.class);
                }
                unmarshallerHandler = jc.createUnmarshaller().getUnmarshallerHandler();
            } catch(JAXBException e) {
                throw new RuntimeException(e);
            }
            unmarshallerHandler.startDocument();
            for(Event event : events) {
                event.event(unmarshallerHandler);
            }
            unmarshallerHandler.endElement(uri, localName, qName);
            xmlReader.setContentHandler(unmarshallerHandler);
        } else {
            events.add(new EndElement(uri, localName, qName));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        events.add(new Characters(ch, start, length));
    }

    public Object getResult() throws JAXBException {
        return unmarshallerHandler.getResult();
    }

    private static abstract class Event {

        public abstract void event(ContentHandler contentHandler) throws SAXException; 

    }

    private static class StartElement extends Event {

        private String uri;
        private String localName;
        private String qName;
        private Attributes attributes;

        public StartElement(String uri, String localName, String qName, Attributes attributes) {
            this.uri = uri;
            this.localName = localName;
            this.qName = qName;
            this.attributes = attributes;
        }

        @Override
        public void event(ContentHandler contentHandler) throws SAXException {
            contentHandler.startElement(uri, localName, qName, attributes);
        }

    }

    private static class Characters extends Event {

        private char[] ch;
        private int start;
        private int length;

        public Characters(char[] ch, int start, int length) {
            this.ch = ch;
            this.start = start;
            this.length = length;
        }

        @Override
        public void event(ContentHandler contentHandler) throws SAXException {
            contentHandler.characters(ch, start, length);
        }

        public String getString() {
            return new String(ch, start, length);
        }

    }

    private static class EndElement extends Event {

        private String uri;
        private String localName;
        private String qName;

        public EndElement(String uri, String localName, String qName) {
            this.uri = uri;
            this.localName = localName;
            this.qName = qName;
        }

        @Override
        public void event(ContentHandler contentHandler) throws SAXException {
            contentHandler.endElement(uri, localName, qName);
        }

    }

}