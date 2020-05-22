import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource source = new StreamSource("input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(source);
        while(!(xsr.isStartElement() && "body".equals(xsr.getLocalName()))) {
            xsr.next();
        }

        JAXBContext jc = JAXBContext.newInstance(wrapper.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        wrapper result = (wrapper) unmarshaller.unmarshal(xsr);
     }

}