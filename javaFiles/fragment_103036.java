package forum10874711;

import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

import forum10874711.b.B;

public class Demo2 {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        List<String> metadata = new ArrayList<String>(2);
        metadata.add("forum10874711/a/binding2.xml");
        metadata.add("forum10874711/b/binding2.xml");
        properties.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, metadata);
        JAXBContext jc = JAXBContext.newInstance(new Class[] {B.class}, properties);

        B b = new B();
        b.setFieldOfClassA("foo");
        b.setFieldOfClassB(123);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(b, System.out);
    }

}