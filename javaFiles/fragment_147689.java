package forum10437439;

import javax.xml.bind.*;
import javax.xml.namespace.QName;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(someClass.class);

        someClass someClass = new someClass();
        someClass.setSomeData(null);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<someClass> je = new JAXBElement<someClass>(new QName("root"), someClass.class, someClass); 
        marshaller.marshal(je, System.out);
    }

}