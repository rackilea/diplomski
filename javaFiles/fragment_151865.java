import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class Demo {

    public static void main(String[] args) throws Exception {
        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        XMLStreamWriter xsw = xof.createXMLStreamWriter(System.out);
        xsw.writeStartDocument();
        xsw.writeStartElement("FOO");

        Bar bar = new Bar();
        bar.setId(1);
        bar.setPoints(111);
        bar.setCode(123);

        JAXBContext jc = JAXBContext.newInstance(Bar.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.marshal(bar, xsw);

        xsw.writeEndElement();
        xsw.writeEndDocument();
        xsw.close();
    }

}