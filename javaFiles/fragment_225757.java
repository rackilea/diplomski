package forum9297872;

import javax.xml.bind.*;
import javax.xml.stream.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        XMLStreamWriter writer = XMLOutputFactory.newFactory().createXMLStreamWriter(System.out);
        writer.setDefaultNamespace("http://www.namespace.com");

        JAXBContext jc = JAXBContext.newInstance(WorkSet.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

        writer.writeStartDocument();
        writer.writeStartElement("http://www.namespace.com", "Import");
        writer.writeNamespace("", "http://www.namespace.com");
        writer.writeStartElement("WorkSets");

        m.marshal(new WorkSet(), writer);
        m.marshal(new WorkSet(), writer);

        writer.writeEndDocument();
        writer.close();
    }

}