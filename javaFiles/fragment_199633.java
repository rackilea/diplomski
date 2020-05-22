package forum12990635;

import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance("forum12990635");

        Foo foo = new Foo();
        foo.setBar("Hello World");

        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<Object> jaxbElement = objectFactory.createGetAllServicesPartnersRequest(foo);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(jaxbElement, System.out);
    }

}