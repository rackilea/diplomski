import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        XMLInputFactory xif = XMLInputFactory.newFactory();

        StreamSource xmlSource = new StreamSource("src/forum19559825/input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xmlSource);

        Demo demo = new Demo();
        demo.positionXMLStreamReaderAtAnyElement(xsr);
        demo.processAnyElement(xsr);
    }

    private void positionXMLStreamReaderAtAnyElement(XMLStreamReader xsr) throws Exception {
        while(xsr.hasNext()) {
            if(xsr.getEventType() == XMLStreamReader.START_ELEMENT && "ANY-ELEMENT".equals(xsr.getLocalName())) {
                break;
            }
            xsr.next();
        }
    }

    private void processAnyElement(XMLStreamReader xmlStreamReaderAtAnyElement) {
        // TODO: Stuff
        System.out.println("FOUND IT");
    }

}